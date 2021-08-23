package tom.company.server.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Current implements Serializable {

    private String observation_time;
    private float temperature;
    List<Object> weather_icons = new ArrayList<>();
    List<Object> weather_descriptions = new ArrayList<>();
    private float wind_speed;
    private float wind_degree;
    private float humidity;
}
