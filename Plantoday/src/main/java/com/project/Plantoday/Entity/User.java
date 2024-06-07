package com.project.Plantoday.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime joinedAt;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Plant> plants;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<ManagementLog> managementLogs;
}
