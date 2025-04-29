package io.dmitrirusnac.utm.course4.tmps.lab2.adapter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonPlaceholderDeliveryService {
  public void sendDelivery(String address) {
    try (HttpClient client = HttpClient.newHttpClient()) {
      String json = String.format("{\"title\": \"Delivery\", \"body\": \"Deliver to %s\", \"userId\": 1}", address);
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create("http://jsonplaceholder.typicode.com/posts"))
          .header("Content-Type", "application/json")
          .POST(HttpRequest.BodyPublishers.ofString(json))
          .build();
      try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Delivery request sent. Response code: " + response.statusCode());
        System.out.println("Response body: " + response.body());
      } catch (IOException | InterruptedException e) {
        System.out.println("Failed to send delivery request: " + e.getMessage());
      }
    }
  }
}
