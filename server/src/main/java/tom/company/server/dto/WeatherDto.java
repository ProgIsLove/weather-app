package tom.company.server.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class WeatherDto implements Serializable {

    private String location;
    private String timestamp;
    private float temperature;
    private List<Object> icons = new ArrayList<>();
    private List<Object> descriptions = new ArrayList<>();
    private float windSpeed;
    private float windDegree;
    private float humidity;
}
