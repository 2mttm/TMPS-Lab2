package io.dmitrirusnac.utm.course4.tmps.lab2.facade;

import io.dmitrirusnac.utm.course4.tmps.lab2.adapter.DeliveryService;
import io.dmitrirusnac.utm.course4.tmps.lab2.decorator.BasicOrder;
import io.dmitrirusnac.utm.course4.tmps.lab2.decorator.DiscountDecorator;
import io.dmitrirusnac.utm.course4.tmps.lab2.decorator.GiftDecorator;
import io.dmitrirusnac.utm.course4.tmps.lab2.decorator.Order;
import io.dmitrirusnac.utm.course4.tmps.lab2.model.FoodItem;
import java.util.List;

public class FoodOrderFacade {
  private final DeliveryService deliveryService;

  public FoodOrderFacade(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
  }

  public void placeOrder(List<FoodItem> items, String address, boolean addGift, boolean addDiscount) {
    Order order = new BasicOrder(items);

    if (addGift) {
      order = new GiftDecorator(order);
    }
    if (addDiscount) {
      order = new DiscountDecorator(order, 0.10); // 10% discount
    }

    System.out.println("Order details: " + order.getDescription());
    System.out.println("Total: $" + order.getTotalPrice());
    deliveryService.deliver(address);
  }
}
