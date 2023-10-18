package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Responce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponceRepository extends JpaRepository<Responce,Long> {
    public Responce findResponceById(Long id);
}
