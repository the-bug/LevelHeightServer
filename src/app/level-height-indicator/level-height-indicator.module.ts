import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LevelHeightIndicatorRoutingModule } from './level-height-indicator-routing.module';
import { MainViewComponent } from './main-view/main-view.component';
import { ResultViewComponent } from './result-view/result-view.component';
import { OneSensorEvoluterComponent } from './one-sensor-evoluter/one-sensor-evoluter.component';

@NgModule({
  imports: [
    CommonModule,
    LevelHeightIndicatorRoutingModule
  ],
  declarations: [MainViewComponent, ResultViewComponent, OneSensorEvoluterComponent]
})
export class LevelHeightIndicatorModule { }
