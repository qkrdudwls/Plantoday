package com.project.Plantoday.Repository;

import com.project.Plantoday.Entity.PlantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantTypeRepository extends JpaRepository<PlantType,Long> {
}
