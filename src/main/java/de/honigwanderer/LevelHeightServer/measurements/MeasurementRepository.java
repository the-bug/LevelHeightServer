package de.honigwanderer.LevelHeightServer.measurements;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

	// List<Measurement> findAll();

}
