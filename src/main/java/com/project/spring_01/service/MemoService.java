package com.project.spring_01.service;


import com.project.spring_01.domain.Memo;
import com.project.spring_01.domain.MemoRepository;
import com.project.spring_01.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor //final 넣을 때 필수
@Service //서비스임을 알려줌
public class MemoService {
    private final MemoRepository memoRepository; //리포지트리 꼭 필요해 : final 사용

    @Transactional //꼭 DB 반영 되어야 한다고 알려줌
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return id;
    }

}