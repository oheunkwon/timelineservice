package com.project.spring_01.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//아래 세개 무조건 있어야 자동으로 시간 불러올 수 있음....!!!! 세개 무조건 자동임
@Getter
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
public abstract class Timestamped {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}