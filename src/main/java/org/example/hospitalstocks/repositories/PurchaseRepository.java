package org.example.hospitalstocks.repositories;

import org.example.hospitalstocks.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
