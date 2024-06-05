package com.project.Plantoday.Controller;

import com.project.Plantoday.DTO.PlantDTO;
import com.project.Plantoday.Entity.Plant;
import com.project.Plantoday.Service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
@RequiredArgsConstructor
public class PlantController {

    private final PlantService plantService;

    @PostMapping
    public ResponseEntity<?> addPlant(@RequestBody PlantDTO plantDTO) {
        plantService.addPlant(plantDTO);
        return ResponseEntity.ok("Plant added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Plant>> getPlants() {
        return ResponseEntity.ok(plantService.getPlants());
    }
}