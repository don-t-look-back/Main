package com.example.main.api;

import com.example.main.dto.request.ChallengeCreateRequestDto;
import com.example.main.dto.response.ChallengeCreateResponseDto;
import com.example.main.service.ChallengeService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/challenge")
public class ChallengeController {

    private final ChallengeService challengeService;

    //
    @Tag(name = "challenge", description = "챌린지 API")
    @Operation(summary = "챌린지 생성 api")
    @PostMapping(value="")
    public ResponseEntity<ChallengeCreateResponseDto> createChallenge(@Parameter(hidden = true) Long memberId,
                                                                      @RequestBody @Valid ChallengeCreateRequestDto req){

        // 1. user app 에서 토큰 확인 > 유저id 가져오기
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();
        //TokenClient tokenClient = new TokenClient(channel);
        //String userId = tokenClient.verifyToken(req.getToken()); // req에 token이 있다고 가정합니다.
        channel.shutdown();

//        if (userId == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }



        // 2. main app(here) 에서 챌린지 생성 > 저장
       // Challenge challenge = challengeService.create(req, memberId);

        //return ResponseEntity.ok(ChallengeCreateResponseDto.create(challenge));
        return null;
    }


}
