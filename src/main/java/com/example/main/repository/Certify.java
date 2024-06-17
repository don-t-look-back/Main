package com.example.main.repository;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "certify")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certify {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participate_id")
    private Participate participate;

    private String name;

    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    public static Certify create(Participate participate, String certifyName, String certifyContent){

        final Certify certify = new CertifyBuilder()
                .participate(participate)
                .name(certifyName)
                .content(certifyContent)
                .build();
        participate.getCertifies().add(certify);
        return certify;
    }

}
