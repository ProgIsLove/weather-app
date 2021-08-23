import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Weather} from "./weather";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getWeatherForCity(city: string): Observable<Weather> {
    return this.http.get<Weather>(`${this.apiServerUrl}/weather/${city}`)
  }
}
