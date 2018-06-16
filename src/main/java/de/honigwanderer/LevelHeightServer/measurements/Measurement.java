package de.honigwanderer.LevelHeightServer.measurements;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Measurement {

	@Id
	@GeneratedValue
	private Long id;

	private Double distanceFromSensor1;

	private Double distanceFromSensor2;

	private Date measurementTime;

	private Measurement() {
	}

	public Measurement(Double distanceFromSensor1, Double distanceFromSensor2, Date measurementTime) {
		this.distanceFromSensor1 = distanceFromSensor1;
		this.distanceFromSensor2 = distanceFromSensor2;
		this.measurementTime = measurementTime;
	}

	public Long getId() {
		return id;
	}

	public Double getDistanceFromSensor1() {
		return distanceFromSensor1;
	}

	public Double getDistanceFromSensor2() {
		return distanceFromSensor2;
	}

	public Date getMeasurementTime() {
		return measurementTime;
	}

}
