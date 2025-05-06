package com.mvr.poliza.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvr.poliza.entitys.EmpleadoEnity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEnity, Integer> { }
