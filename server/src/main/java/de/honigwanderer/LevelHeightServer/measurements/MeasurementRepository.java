package de.honigwanderer.LevelHeightServer.measurements;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

	List<Measurement> findTop50ByOrderByMeasurementTimeDesc();
	
	Measurement findTop1ByOrderByMeasurementTimeDesc();
	
	@Transactional
	void deleteInBulkByMeasurementTimeBefore(Date date);
}
