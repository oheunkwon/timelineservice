package com.project.spring_01.controller;

import com.project.spring_01.domain.Memo;
import com.project.spring_01.domain.MemoRepository;
import com.project.spring_01.domain.MemoRequestDto;
import com.project.spring_01.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Memocontroller {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    //create
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    //read
    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
        LocalDateTime endDatetime = LocalDateTime.now();
        LocalDateTime startDatetime = LocalDateTime.now().minusDays(1);
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(startDatetime, endDatetime);

    }
    //delete
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }

    //update -> service
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

}
