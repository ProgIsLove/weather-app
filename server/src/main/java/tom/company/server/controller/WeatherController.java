package tom.company.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tom.company.server.dto.WeatherDto;
import tom.company.server.service.WeatherService;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @RequestMapping("/{city}")
    @Cacheable(cacheNames = "weather")
    public WeatherDto weatherForCity(@PathVariable String city) {
        return weatherService.weatherForCity(city);
    }
}
