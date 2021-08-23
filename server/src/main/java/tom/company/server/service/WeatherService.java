package tom.company.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tom.company.server.connector.ApixuConnector;
import tom.company.server.dto.ApixuDto;
import tom.company.server.dto.WeatherDto;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final ApixuConnector apixuConnector;

    public WeatherDto weatherForCity(@PathVariable String city) {
        ApixuDto apixuDto = apixuConnector.getWeatherForCity(city);
        return transformDto(apixuDto);
    }

    private WeatherDto transformDto(ApixuDto apixuDto) {
        return WeatherDto.builder()
                  .location(apixuDto.getLocation().getName())
                  .temperature(apixuDto.getCurrent().getTemperature())
                  .humidity(apixuDto.getCurrent().getHumidity())
                  .descriptions(apixuDto.getCurrent().getWeather_descriptions())
                  .icons(apixuDto.getCurrent().getWeather_icons())
                  .timestamp(apixuDto.getCurrent().getObservation_time())
                  .windDegree(apixuDto.getCurrent().getWind_degree())
                  .windSpeed(apixuDto.getCurrent().getWind_speed())
                  .build();
    }
}
