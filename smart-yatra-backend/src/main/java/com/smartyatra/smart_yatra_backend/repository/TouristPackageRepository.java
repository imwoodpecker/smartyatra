package com.smartyatra.smart_yatra_backend.repository;

import com.smartyatra.smart_yatra_backend.entity.TouristPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TouristPackageRepository extends JpaRepository<TouristPackage,Long> {
    List<TouristPackage> findByCityContainingIgnoreCase(String city);
    List<TouristPackage> findByHostId(Long hostId);
    List<TouristPackage> findAll();
}