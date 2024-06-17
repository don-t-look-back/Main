package com.example.main.service;

import com.example.main.repository.Challenge;
import com.example.main.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public List<Challenge> getChallenges() {

        return challengeRepository.findAll();
    }
    // private final MemberRepository memberRepository;
}
