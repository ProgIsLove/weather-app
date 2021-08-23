package tom.company.server.connector;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import tom.company.server.dto.ApixuDto;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Configuration
public class ApixuConnector {

    private static final String BASE_URL = "http://api.weatherstack.com/";
    private static final String PARAMS_URL = "current?access_key=";
    private static final String APIKEY = "10400dc84443c467be019cc6cef2974c";
    private static final String URL = BASE_URL + PARAMS_URL + APIKEY + "&query=";

    public ApixuDto getWeatherForCity(String city) {
        WebClient client = WebClient.create();
        URI uri = null;
        try {
            uri = new URI(URL + URLEncoder.encode(city, StandardCharsets.UTF_8.toString()));
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return client.get()
                     .uri(Objects.requireNonNull(uri))
                     .retrieve()
                     .bodyToMono(ApixuDto.class)
                     .block();
    }
}
