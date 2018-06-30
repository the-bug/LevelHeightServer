package de.honigwanderer.LevelHeightServer.measurements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MeasurementRepositoryScheduledTasks {

	private final MeasurementRepository measurementRepository;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private static final Logger log = LoggerFactory.getLogger(MeasurementRepositoryScheduledTasks.class);

	@Autowired
	MeasurementRepositoryScheduledTasks(MeasurementRepository measurementRepository) {
		this.measurementRepository = measurementRepository;
	}

	@Scheduled(cron = "0 0 */1 * * ?")
	public void deleteObsoleteMeasurementsPeriodacally() {
		log.info("started deleteObsoleteMeasurements at {}", dateFormat.format(new Date()));

		deleteObsoleteMeasurements();

		log.info("finished deleteObsoleteMeasurements at {}", dateFormat.format(new Date()));
	}

	void deleteObsoleteMeasurements() {
		Measurement lastMeasurement = measurementRepository.findTop1ByOrderByMeasurementTimeDesc();
		if (lastMeasurement != null) {
			Date lastMeasurementTime = lastMeasurement.getMeasurementTime();
			Date lastMeasurementTimeToKeep = new Date(lastMeasurementTime.getTime() - TimeUnit.HOURS.toMillis(1));

			measurementRepository.deleteInBulkByMeasurementTimeBefore(lastMeasurementTimeToKeep);
		}
	}

}
