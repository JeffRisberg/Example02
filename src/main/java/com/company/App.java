package com.company;

import com.company.services.ItemService;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 */
public class App {

  private int averagePrice = 0;

  public App() {
    Injector injector = Guice.createInjector(new AppModule());

    ItemService itemService  = injector.getInstance(ItemService.class);

    averagePrice = itemService.getAveragePrice();
  }

  public int getAveragePrice() {
    return averagePrice;
  }

  public static void main(String[] args) {

    System.out.println(new App().getAveragePrice());
  }
}
