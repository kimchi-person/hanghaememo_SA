package com.sparta.hanghaememo_sa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDto {
    private String title;
    private String author;
    private String contents;
    private String password;
}
