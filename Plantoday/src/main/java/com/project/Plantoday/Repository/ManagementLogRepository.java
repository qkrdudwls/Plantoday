package com.project.Plantoday.Repository;

import com.project.Plantoday.Entity.ManagementLog;
import com.project.Plantoday.Entity.Plant;
import com.project.Plantoday.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagementLogRepository extends JpaRepository<ManagementLog, Long> {
    List<ManagementLog> findAllByPlant(Plant plant);
    List<ManagementLog> findByUser(User user);
    List<ManagementLog> findByUserAndPlant(User user, Plant plant);
}