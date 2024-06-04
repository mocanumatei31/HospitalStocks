package org.example.hospitalstocks.repositories;

import org.example.hospitalstocks.models.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, String> {
}
