package io.dmitrirusnac.utm.course4.tmps.lab2.decorator;

public class DiscountDecorator extends OrderDecorator {
  private double discount;

  public DiscountDecorator(Order order, double discount) {
    super(order);
    this.discount = discount;
  }

  @Override
  public double getTotalPrice() {
    return order.getTotalPrice() * (1 - discount);
  }

  @Override
  public String getDescription() {
    return order.getDescription() + ", with " + (int)(discount * 100) + "% discount";
  }
}
