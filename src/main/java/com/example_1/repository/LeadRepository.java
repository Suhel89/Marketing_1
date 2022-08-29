package com.example_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example_1.Entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
