package io.dmitrirusnac.utm.course4.tmps.lab2.decorator;

public class GiftDecorator extends OrderDecorator {
  public GiftDecorator(Order order) {
    super(order);
  }

  @Override
  public String getDescription() {
    return order.getDescription() + ", includes a free gift";
  }
}
