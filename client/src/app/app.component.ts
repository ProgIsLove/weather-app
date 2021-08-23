import { Component } from '@angular/core';
import {Weather} from "./weather";
import {WeatherService} from "./weather.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';
  public weather: Weather;

  constructor(private weatherService: WeatherService) {
    this.weather = {};
  }

  public getWeather(city: string): void {
    this.weatherService.getWeatherForCity(city).subscribe(
      (response: Weather) => {
        this.weather = response;
        console.log(this.weather)
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }
}
