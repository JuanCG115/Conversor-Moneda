import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyService {
    private static final String API_KEY = System.getenv("API_KEY");

    static {
        if (API_KEY == null || API_KEY.isBlank()) {
            throw new RuntimeException(
                    "La variable de entorno API_KEY no está configurada.\n" +
                            "Configúrala antes de ejecutar la aplicación."
            );
        }
    }

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client;
    private final Gson gson;

    public CurrencyService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ExchangeResponse getRates(String base) throws Exception {

        String url = BASE_URL + API_KEY + "/latest/" + base;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error HTTP: " + response.statusCode());
        }

        return gson.fromJson(response.body(), ExchangeResponse.class);
    }
}
