package gmap;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AeroFetcher {
    public static String getDeparturesInterval(String iataCode, int offsetMinutes, int durationMinutes, String apiKey, String apiHost) throws IOException, InterruptedException {
    String uri = "https://aerodatabox.p.rapidapi.com/flights/airports/iata/" + iataCode
               + "?offsetMinutes=" + offsetMinutes
               + "&durationMinutes=" + durationMinutes
               + "&direction=Departure"
               + "&withCancelled=true"
               + "&withCodeshared=true"
               + "&withPrivate=false"
               + "&withLocation=false";

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .header("X-RapidAPI-Key", apiKey)
            .header("X-RapidAPI-Host", apiHost)
            .build();

    HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    if (response.statusCode() != 200) {
        throw new IOException("API error (offset " + offsetMinutes + "): " + response.body());
    }

    return response.body();
}

}
