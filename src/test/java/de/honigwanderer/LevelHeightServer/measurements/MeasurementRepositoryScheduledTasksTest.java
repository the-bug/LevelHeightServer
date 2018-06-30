package de.honigwanderer.LevelHeightServer.measurements;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MeasurementRepositoryScheduledTasksTest {

	@Autowired
	private MeasurementRepository measurementRepository;

	@Autowired
	private MeasurementRepositoryScheduledTasks measurementRepositoryScheduledTasks;

	@Before
	public void setUp() {
		Date measurementTimeNow = new Date();

		Measurement Measurement1 = new Measurement(1d, 12d, measurementTimeNow);
		this.measurementRepository.save(Measurement1);

		Measurement Measurement2 = new Measurement(1d, 12d,
				new Date(measurementTimeNow.getTime() - 2 * TimeUnit.HOURS.toMillis(1)));
		this.measurementRepository.save(Measurement2);
	}

	@Test
	public void test_deleteObsoleteMeasurements() {
		measurementRepositoryScheduledTasks.deleteObsoleteMeasurements();

		assertThat(this.measurementRepository.findTop50ByOrderByMeasurementTimeDesc().size()).isEqualTo(1);
	}

}
