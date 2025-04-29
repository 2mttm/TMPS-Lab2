package io.dmitrirusnac.utm.course4.tmps.lab2.adapter;

public class DeliveryAdapter implements DeliveryService {
  private JsonPlaceholderDeliveryService jsonPlaceholderService;

  public DeliveryAdapter(JsonPlaceholderDeliveryService jsonPlaceholderService) {
    this.jsonPlaceholderService = jsonPlaceholderService;
  }

  @Override
  public void deliver(String address) {
    jsonPlaceholderService.sendDelivery(address);
  }
}