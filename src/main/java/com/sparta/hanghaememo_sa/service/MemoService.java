package com.sparta.hanghaememo_sa.service;


import com.sparta.hanghaememo_sa.dto.RequestDto;
import com.sparta.hanghaememo_sa.dto.ResponseDto;
import com.sparta.hanghaememo_sa.dto.ResultDto;
import com.sparta.hanghaememo_sa.entity.Memo;
import com.sparta.hanghaememo_sa.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;


    @Transactional(readOnly = true)
    public List<ResponseDto> getMemos() {
        List<Memo> memos = memoRepository.findAllByOrderByModifiedAtDesc();

        List<ResponseDto> memo_list = new ArrayList<>();
        for (Memo memo : memos) {
            ResponseDto responseDto = new ResponseDto(memo);
            memo_list.add(responseDto);
        }
        return memo_list;
    }

    public ResponseDto getMemo(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글이 없습니다."));
        return new ResponseDto(memo);
    }

    public ResponseDto createMemo(RequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return new ResponseDto(memo);
    }

    public ResponseDto updateMemo(Long id, RequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글을 찾을 수 없습니다."));
        if (memo.getPassword().equals(requestDto.getPassword())) {
            memo.updateMemo(memo);
            return new ResponseDto(memo);
        } else {
            throw new IllegalArgumentException("비밀번호가 다릅니다");
        }
    }

    public ResultDto deleteMemo(Long id, RequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글을 찾을 수 없습니다.")
        );
        if (memo.getPassword().equals(requestDto.getPassword())) {
            memoRepository.delete(memo);
            return new ResultDto(true);
        }else {
            return new ResultDto(false);
        }
    }
}
