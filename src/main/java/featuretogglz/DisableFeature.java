package featuretogglz;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DisableFeature {
    public static void callToDisableFeature(String featureName) throws IOException, InterruptedException {
        JSONObject json = new JSONObject();
        json.put("name", featureName);
        json.put("enabled", false);

        HttpRequest post_request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("http://localhost:8080/actuator/togglz/%s", featureName)))
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> post_response = HttpClient.newHttpClient().send(post_request, HttpResponse.BodyHandlers.ofString());
        System.out.println(post_response.body());
    }
}
