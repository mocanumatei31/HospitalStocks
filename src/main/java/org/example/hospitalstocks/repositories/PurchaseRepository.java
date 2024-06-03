package org.example.hospitalstocks.repositories;

import org.example.hospitalstocks.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
