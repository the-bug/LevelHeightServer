import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { SensorData } from './SensorData';

@Component({
  selector: 'app-one-sensor-evoluter',
  templateUrl: './one-sensor-evoluter.component.html',
  styleUrls: ['./one-sensor-evoluter.component.css']
})
export class OneSensorEvoluterComponent implements OnInit, OnChanges {

  @Input()
  sensorData: Array<SensorData>;

  @Input()
  title: string;

  actuellMeasurmentDistance: number;

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(changes: { [propKey: string]: SimpleChange }) {
    if (this.sensorData) {
      this.actuellMeasurmentDistance = this.sensorData[0].distance;
    }
  }

}
