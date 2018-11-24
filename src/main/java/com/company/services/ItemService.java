package com.company.services;

import com.company.models.Item;
import com.company.stores.ItemStore;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ItemService {

  private ItemStore userStore = new ItemStore();

  public int getAveragePrice() {

    List<Item> items = userStore.readAllItems();

    int sumOfPrices = 0;
    for (Item item : items) {
      sumOfPrices += item.getPrice();
    }

    return (sumOfPrices / items.size());
  }

  public String getItemNameUpperCase(long itemId) {

    Item item = userStore.findById(itemId);

    return StringUtils.upperCase(item.getName());
  }
}
