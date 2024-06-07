package com.project.Plantoday.DTO;

import lombok.Data;

@Data
public class PlantDTO {
    private String name;
    private Long plantTypeId;
    private String photoUrl;
    private String memo;
    private String status;
}
