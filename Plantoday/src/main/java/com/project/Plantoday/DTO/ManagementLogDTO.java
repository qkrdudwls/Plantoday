package com.project.Plantoday.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagementLogDTO {
    private Long plantId;
    private LocalDateTime createdAt;
    private Integer watering;
    private String photoUrl;
    private Integer currentTemp;
    private Integer currentHumi;
    private String sunlight;
    private String memo;
}
