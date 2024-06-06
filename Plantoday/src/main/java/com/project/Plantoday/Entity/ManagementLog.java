package com.project.Plantoday.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ManagementLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="plant_id",nullable = false)
    @JsonIgnore
    private Plant plant;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // 메모
    @Column(nullable = false)
    private String content;

    // 물 주기 여부
    @Column(nullable = false)
    private Integer watering;

    // 당시 온도
    @Column(nullable = false)
    private Integer currentTemp;

    // 일조량
    @Column(nullable = false)
    private String sunlight;

    // 사진 url
    @Column
    private String photoUrl;
}
