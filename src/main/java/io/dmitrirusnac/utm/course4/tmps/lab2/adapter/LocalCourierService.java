package io.dmitrirusnac.utm.course4.tmps.lab2.adapter;

import java.time.LocalDateTime;

public class LocalCourierService {
  public void logDeliveryToConsole(String destination) {
    System.out.println("[LocalCourierService] Delivery logged: " + destination + " at " + LocalDateTime.now());
  }
}
