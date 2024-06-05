package com.project.Plantoday.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="plant_type_id",nullable = false)
    private PlantType plantType;

    // 이름
    @Column(nullable = false)
    private String name;

    // 시작 날짜
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String status;

    // 사진 url
    @Column
    private String photoUrl;

    // memo
    @Column
    private String memo;

    @OneToMany(mappedBy = "plant")
    private List<ManagementLog> managementLogs;
}
