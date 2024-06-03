package org.example.hospitalstocks.repositories;

import org.example.hospitalstocks.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, String> {
    List<Drug> findByNameContaining(String name);
    Drug findByNameLike(String name);
}
