package com.example.main.repository;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "participate")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Participate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT", nullable = false, unique = true)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @OneToMany(mappedBy = "participate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certify> certifies;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;



    public static Participate create(Long memberId, Challenge challenge){

        return Participate.builder()
                .memberId(memberId)
                .challenge(challenge)
                .build();
    }

}