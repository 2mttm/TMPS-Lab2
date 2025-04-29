package io.dmitrirusnac.utm.course4.tmps.lab2.decorator;

public abstract class OrderDecorator implements Order {
  protected Order order;

  public OrderDecorator(Order order) {
    this.order = order;
  }

  public double getTotalPrice() {
    return order.getTotalPrice();
  }

  public String getDescription() {
    return order.getDescription();
  }
}
