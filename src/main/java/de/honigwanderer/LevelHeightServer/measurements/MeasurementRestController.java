package de.honigwanderer.LevelHeightServer.measurements;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("Measurements")
public class MeasurementRestController {

	private final MeasurementRepository measurementRepository;

	@Autowired
	MeasurementRestController(MeasurementRepository measurementRepository) {
		this.measurementRepository = measurementRepository;
	}

	@GetMapping
	List<Measurement> readMeasurement() {
		return this.measurementRepository.findTop50ByOrderByMeasurementTimeDesc();
	}

	@PostMapping
	ResponseEntity<?> add (@RequestBody Measurement input) {
		
		Measurement result = this.measurementRepository.save(new Measurement(input.getDistanceFromSensor1(),
				input.getDistanceFromSensor2(),
				new Date()));
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
