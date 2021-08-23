export interface Weather {
  location?: string;
  timestamp?: string;
  temperature?: number;
  icons?: object[];
  descriptions?: object[];
  windSpeed?: number;
  windDegree?: number;
  humidity?: number;
}
