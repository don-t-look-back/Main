package com.example.main.dto.request;

import com.example.main.repository.Challenge;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ChallengeCreateRequestDto {

    @Schema(description = "챌린지 아이콘 선택", example = "T: 재테크, M: 돈관리, L: 금융학습, C: 소비절약 ", required=true)
    private Character challengeBranch;

    @Schema(description = "챌린지 제목", example = "매일 작업하기", required=true)
    private String challengeName;

    @Schema(description = "챌린지 소개", example = "챌린지 소개~~", required=true)
    private String challengeInfo;

    public Challenge toEntity(){
        return Challenge.builder()
                .branch(challengeBranch)
                .name(challengeName)
                .info(challengeInfo)
                .build();
    }

}
