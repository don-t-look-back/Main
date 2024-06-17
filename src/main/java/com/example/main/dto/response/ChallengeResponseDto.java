package com.example.main.dto.response;


import com.example.main.repository.Challenge;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ChallengeResponseDto {

    @Schema(description = "챌린지 id", example = "10")
    private Long id;

    @Schema(description = "챌린지 제목", example = "소비습관 고치기")
    private String name;

    @Schema(description = "챌린지 분야", example = "재태크/돈관리/금융학습/소비절약")
    private Character branch;

    @Schema(description = "챌린지 참여인원", example = "38")
    private Long count;


    public static ChallengeResponseDto from(Challenge challenge){

        return new ChallengeResponseDtoBuilder()
                .id(challenge.getId())
                .name(challenge.getName())
                .branch(challenge.getBranch())
                .count(challenge.getCount())
                .build();
    }

}
