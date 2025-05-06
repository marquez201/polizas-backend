package com.mvr.poliza.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvr.poliza.entitys.PolizaEntity;

@Repository
public interface PolizaRepository extends JpaRepository<PolizaEntity, Integer> { }
