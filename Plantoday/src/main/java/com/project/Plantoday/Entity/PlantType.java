package com.project.Plantoday.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class PlantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String plantTypeName;

    @Column(nullable = false)
    private Integer wateringInterval;

    @Column(nullable = false)
    private String temperatureInfo;

    @Column(nullable = false)
    private String humidityInfo;

    @OneToMany(mappedBy = "plantType")
    @JsonIgnore
    private List<Plant> plants;
}
