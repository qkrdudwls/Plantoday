package com.project.Plantoday.DTO;

import lombok.Data;

@Data
public class PlantTypeDTO {
    private String plantTypeName;
    private Integer wateringInterval;
    private String temperatureInfo;
    private String humidityInfo;
}
