package com.project.Plantoday.Service;

import com.project.Plantoday.DTO.PlantDTO;
import com.project.Plantoday.Entity.Plant;
import com.project.Plantoday.Entity.PlantType;
import com.project.Plantoday.Entity.User;
import com.project.Plantoday.Repository.PlantRepository;
import com.project.Plantoday.Repository.PlantTypeRepository;
import com.project.Plantoday.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepository plantRepository;
    private final UserRepository userRepository;
    private final PlantTypeRepository plantTypeRepository;
    public void addPlant(PlantDTO plantDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        Plant plant = new Plant();
        PlantType plantType=plantTypeRepository.findById(plantDTO.getPlantTypeId()).orElseThrow(()->new IllegalArgumentException("Invalid plant type"));
        plant.setUser(user);
        plant.setPlantType(plantType);
        plant.setName(plantDTO.getName());
        plant.setStatus(plantDTO.getStatus());
        plant.setCreatedAt(LocalDateTime.now());
        plant.setPhotoUrl(plant.getPhotoUrl());
        plant.setMemo(plantDTO.getMemo());
        plantRepository.saveAndFlush(plant);
    }

    public List<Plant> getPlants() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return plantRepository.findAllByUserUsername(username);
    }

    public Plant getPlantById(Long plantId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        return plantRepository.findByIdAndUser(plantId, user)
                .orElseThrow(() -> new IllegalArgumentException("Plant not found"));
    }

    public List<Plant> getPlantsForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        return plantRepository.findByUser(user);
    }
}