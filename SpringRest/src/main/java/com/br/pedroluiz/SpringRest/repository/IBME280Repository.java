package com.br.pedroluiz.SpringRest.repository;

import java.time.LocalDate;


import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pedroluiz.SpringRest.model.entity.BME280;

public interface IBME280Repository extends JpaRepository<BME280, LocalDate> {

	BME280 findById(String localDateTime);

}
