package com.sparta.hanghaememo_sa.dto;

import com.sparta.hanghaememo_sa.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ResultDto {
    private Boolean success;
    public ResultDto(boolean Boolean) {
        this.success = Boolean;
    }


}
