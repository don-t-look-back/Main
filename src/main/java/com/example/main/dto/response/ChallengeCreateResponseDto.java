package com.example.main.dto.response;


import com.example.main.repository.Challenge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ChallengeCreateResponseDto {

    // @Schema(description = "챌린지 id", example = "10")
    private Long challengeId;

    public static ChallengeCreateResponseDto create(Challenge challenge) {
        return ChallengeCreateResponseDto.builder()
               // .challengeId(challenge.getChallengeId())
                .build();
    }
}