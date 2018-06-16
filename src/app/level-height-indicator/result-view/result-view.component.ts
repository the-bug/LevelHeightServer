import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MeasurmentsRestDTO } from './../MeasurmentsRestDTO';

@Component({
  selector: 'app-result-view',
  templateUrl: './result-view.component.html',
  styleUrls: ['./result-view.component.css']
})
export class ResultViewComponent implements OnInit {

  actuellData: Array<MeasurmentsRestDTO>;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    const newLocal = 'http://localhost:8080' + '/Measurements';
    this.http.get<MeasurmentsRestDTO[]>(newLocal).subscribe( t => {
      this.actuellData = t;
    })

  }

}
