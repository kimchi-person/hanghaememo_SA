package com.sparta.hanghaememo_sa.controller;


import com.sparta.hanghaememo_sa.dto.RequestDto;
import com.sparta.hanghaememo_sa.dto.ResponseDto;
import com.sparta.hanghaememo_sa.dto.ResultDto;
import com.sparta.hanghaememo_sa.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;


    // 모든 게시물 보여주기
    @GetMapping("/api/posts")
    public List<ResponseDto> getMemos() {
        return memoService.getMemos();
    }

    // 특정 id값으로 하나만 가져오기
    @GetMapping("/api/post/{id}")
    public ResponseDto getMemo(@PathVariable Long id) {
        return memoService.getMemo(id);
    }

    // 게시물 작성
    @PostMapping("/api/post")
    public ResponseDto createMemo(@RequestBody RequestDto requestDto) {
        return memoService.createMemo(requestDto);
    }

    // 업데이트
    @PutMapping ("/api/post/{id}")
    public ResponseDto updateMemo(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        return memoService.updateMemo(id, requestDto);
    }
    // 삭제하기
    @DeleteMapping("/api/post/{id}")
    public ResultDto deleteMemo(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        return memoService.deleteMemo(id, requestDto);
    }
}
