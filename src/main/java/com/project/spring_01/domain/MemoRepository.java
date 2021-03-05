package com.project.spring_01.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    //List<Memo> findAllByOrderByModifiedAtDesc();
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
    //수정된 날짜 기준으로 최신순으로 정렬해서 가지고 와줘 라는 함수....
}