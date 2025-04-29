package io.dmitrirusnac.utm.course4.tmps.lab2.adapter;

public class LocalCourierAdapter implements DeliveryService {
  private final LocalCourierService localService;

  public LocalCourierAdapter(LocalCourierService localService) {
    this.localService = localService;
  }

  @Override
  public void deliver(String address) {
    localService.logDeliveryToConsole(address);
  }
}
