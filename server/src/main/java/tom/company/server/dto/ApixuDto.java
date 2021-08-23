package tom.company.server.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ApixuDto implements Serializable {

    private Location location;
    private Current current;
}
