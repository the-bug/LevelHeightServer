import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';


const appRoutes: Routes = [
  {
    path: 'Monitor',
    loadChildren: './level-height-indicator/level-height-indicator.module#LevelHeightIndicatorModule'
  },

  {
    path: '',
    redirectTo: 'Monitor',
    pathMatch: 'full' 
  },
  {
    path: '**',
    redirectTo: 'Monitor'
  }
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
