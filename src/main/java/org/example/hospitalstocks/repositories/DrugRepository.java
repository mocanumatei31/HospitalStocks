package org.example.hospitalstocks.repositories;

import org.example.hospitalstocks.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, String> {
}
