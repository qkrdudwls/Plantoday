package com.project.Plantoday.Repository;

import com.project.Plantoday.Entity.Plant;
import com.project.Plantoday.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findAllByUserUsername(String username);
    Optional<Plant> findByIdAndUser(Long id, User user);
    List<Plant> findByUser(User user);
}
