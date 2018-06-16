import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MeasurmentsRestDTO } from './../MeasurmentsRestDTO';
import { SensorData } from '../one-sensor-evoluter/SensorData';

@Component({
  selector: 'app-result-view',
  templateUrl: './result-view.component.html',
  styleUrls: ['./result-view.component.css']
})
export class ResultViewComponent implements OnInit {

  actuellData: Array<MeasurmentsRestDTO>;

  sensorData1: Array<SensorData>;
  sensorData2: Array<SensorData>;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getNewData();
  }


  private getNewData() {
    const newLocal = 'http://localhost:8080' + '/Measurements';
    this.http.get<MeasurmentsRestDTO[]>(newLocal).subscribe(t => {
      this.actuellData = t;
      this.sensorData1 = this.actuellData.map(dto => {
        const ret: SensorData = {
          distance: dto.distanceFromSensor1,
          measurementTime: dto.measurementTime
        };
        return ret;
      });
      this.sensorData2 = this.actuellData.map(dto => {
        const ret: SensorData = {
          distance: dto.distanceFromSensor2,
          measurementTime: dto.measurementTime
        };
        return ret;
      });
    });
  }
}
