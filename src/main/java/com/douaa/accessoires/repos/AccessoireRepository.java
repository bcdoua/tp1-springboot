package com.douaa.accessoires.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douaa.accessoires.entities.Accessoire;

public interface AccessoireRepository extends JpaRepository<Accessoire, Long> {

}
