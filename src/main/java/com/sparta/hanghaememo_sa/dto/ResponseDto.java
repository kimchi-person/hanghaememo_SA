package com.sparta.hanghaememo_sa.dto;

import com.sparta.hanghaememo_sa.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ResponseDto {

    private Long id;
    private String title;
    private String author;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public ResponseDto(Memo memo) {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.author = memo.getAuthor();
        this.contents = memo.getContents();
        this.createdAt = memo.getCreateAt();
        this.modifiedAt = memo.getModifiedAt();
    }
}
