package io.dmitrirusnac.utm.course4.tmps.lab2.decorator;

import io.dmitrirusnac.utm.course4.tmps.lab2.model.FoodItem;
import java.util.List;

public class BasicOrder implements Order {
  private final List<FoodItem> items;

  public BasicOrder(List<FoodItem> items) {
    this.items = items;
  }

  @Override
  public double getTotalPrice() {
    return items.stream().mapToDouble(FoodItem::getPrice).sum();
  }

  @Override
  public String getDescription() {
    return "Basic order with " + items.size() + " items";
  }
}
