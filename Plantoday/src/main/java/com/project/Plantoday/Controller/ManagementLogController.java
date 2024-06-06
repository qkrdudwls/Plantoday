package com.project.Plantoday.Controller;

import com.project.Plantoday.DTO.ManagementLogDTO;
import com.project.Plantoday.Entity.ManagementLog;
import com.project.Plantoday.Service.ManagementLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management-logs")
@RequiredArgsConstructor
public class ManagementLogController {

    private final ManagementLogService managementLogService;

    @PostMapping
    public ResponseEntity<?> addManagementLog(@RequestBody ManagementLogDTO managementLogDTO){
        managementLogService.addManagementLog(managementLogDTO);
        return ResponseEntity.ok("Management log added successfully");
    }

    @GetMapping("{plantId}")
    public ResponseEntity<List<ManagementLog>>getManagementLogs(@PathVariable("plantId") Long plantId){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        return ResponseEntity.ok(managementLogService.getLogsForUserAndPlant(username, plantId));
    }

    @GetMapping
    public ResponseEntity<List<ManagementLog>> getAllManagementLogsForUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok(managementLogService.getAllLogsForUser(username));
    }

}