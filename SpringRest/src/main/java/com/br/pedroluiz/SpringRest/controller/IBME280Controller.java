package com.br.pedroluiz.SpringRest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.br.pedroluiz.SpringRest.model.entity.BME280;
import com.br.pedroluiz.SpringRest.model.dto.BME280DTO;


public interface IBME280Controller {
	public List<BME280DTO> listaBME280();
	public ResponseEntity<BME280DTO> buscaBME280(String localDateTime);
	public ResponseEntity<String> adicionaBME280(BME280 b);
	public ResponseEntity<String> atualizaBME280(BME280 b);
	public ResponseEntity<String> excluiBME280(BME280 b);
}
