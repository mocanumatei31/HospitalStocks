package org.example.hospitalstocks.repositories;

import org.example.hospitalstocks.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, String> {
    Manufacturer findByNameLike(String name);
}
