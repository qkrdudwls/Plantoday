package com.project.Plantoday.Service;

import com.project.Plantoday.DTO.ManagementLogDTO;
import com.project.Plantoday.Entity.ManagementLog;
import com.project.Plantoday.Entity.Plant;
import com.project.Plantoday.Entity.User;
import com.project.Plantoday.Repository.ManagementLogRepository;
import com.project.Plantoday.Repository.PlantRepository;
import com.project.Plantoday.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagementLogService {
    private final ManagementLogRepository managementLogRepository;
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    public void addManagementLog(ManagementLogDTO managementLogDTO){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userRepository.findByUsername(username);
        Plant plant=plantRepository.findByIdAndUser(managementLogDTO.getPlantId(),user).orElseThrow(()->new IllegalArgumentException("Plant not found or not authorized"));
        ManagementLog managementLog=new ManagementLog();
        managementLog.setPlant(plant);
        managementLog.setWatering(managementLogDTO.getWatering());
        managementLog.setCurrentTemp(managementLogDTO.getCurrentTemp());
        managementLog.setContent(managementLogDTO.getMemo());
        managementLog.setCreatedAt(LocalDateTime.now());
        managementLog.setSunlight(managementLogDTO.getSunlight());
        managementLog.setPhotoUrl(managementLog.getPhotoUrl());
        managementLogRepository.saveAndFlush(managementLog);
    }
    public List<ManagementLog> getManagementLogs(Long plantId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user = userRepository.findByUsername(username);
        Plant plant = plantRepository.findByIdAndUser(plantId, user)
                .orElseThrow(() -> new IllegalArgumentException("Plant not found or not authorized"));
        return managementLogRepository.findAllByPlant(plant);
    }

    public List<ManagementLog> getAllLogs() {
        return managementLogRepository.findAll();
    }
}