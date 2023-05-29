package com.br.pedroluiz.SpringRest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedroluiz.SpringRest.model.dto.BME280DTO;
import com.br.pedroluiz.SpringRest.model.entity.BME280;
import com.br.pedroluiz.SpringRest.repository.IBME280Repository;

@RestController
@RequestMapping("/api")
public class BME280Controller implements IBME280Controller {
	
	@Autowired
	IBME280Repository b280;

	@Override
	@GetMapping("/bme280")
	public List<BME280DTO> listaBME280() {
		List<BME280> list = b280.findAll();
		List<BME280DTO> lista = converteListaBME280ListaBME280DTO(list);
		return lista;
	}

	@Override
	@GetMapping("/bme280/{localDateTime}")
	public ResponseEntity<BME280DTO> buscaBME280(@PathVariable String localDateTime) {
		BME280 bme280 = b280.findById(localDateTime); 
		BME280DTO bme280DTO = converteBME280BME280DTO(bme280);
		return ResponseEntity.ok().body(bme280DTO);
							
	}

	@Override
	@PostMapping("/bme280")
	public ResponseEntity<String> adicionaBME280(@Valid @RequestBody BME280 b) {
		BME280 bme280 = converteBME280DTOBME280(b);
		b280.save(bme280);
		String saida = "Bme280 inserido com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@PutMapping("/bme280")
	public ResponseEntity<String> atualizaBME280(@Valid @RequestBody BME280 b) {
		BME280 bme280 = converteBME280DTOBME280(b);
		b280.save(bme280);
		String saida = "Bme280 atualizado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@DeleteMapping("/bme280")
	public ResponseEntity<String> excluiBME280(@Valid @RequestBody BME280 b) {
		BME280 bme280 = converteBME280DTOBME280(b);
		b280.delete(bme280);
		String saida = "Bme280 excluido com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	private List<BME280DTO> converteListaBME280ListaBME280DTO(List<BME280> listBme280) {
		List<BME280DTO> listaBME280DTO = new ArrayList<>();
		for (BME280 bme280 : listBme280) {
			BME280DTO bme280DTO = new BME280DTO();
			bme280DTO.setLocalDateTime(bme280.getLocalDateTime());
			bme280DTO.setHumidity(bme280.getHumidity());
			bme280DTO.setPressure(bme280.getPressure());
			bme280DTO.setTemperature(bme280.getTemperature());
			listaBME280DTO.add(bme280DTO);
		}
		return listaBME280DTO;
	}
	
	private BME280DTO converteBME280BME280DTO(@Valid BME280 b) {
		BME280DTO bmeDTO = new BME280DTO();
		bmeDTO.setLocalDateTime(b.getLocalDateTime());
		bmeDTO.setHumidity(b.getHumidity());
		bmeDTO.setPressure(b.getPressure());
		bmeDTO.setTemperature(b.getTemperature());
		return bmeDTO;
	}
	
	private BME280 converteBME280DTOBME280(@Valid BME280 bDTO) {
		BME280 bme280 = new BME280();
		bDTO.setLocalDateTime(bDTO.getLocalDateTime());
		bDTO.setHumidity(bDTO.getHumidity());
		bDTO.setPressure(bDTO.getPressure());
		bDTO.setTemperature(bDTO.getTemperature());
		return bme280;
	}

}
