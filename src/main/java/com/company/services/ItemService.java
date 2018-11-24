package com.company.services;

import com.company.models.Item;
import com.company.stores.ItemStore;
import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ItemService {

  private ItemStore itemStore;

  @Inject
  public ItemService(ItemStore itemStore) {
    this.itemStore = itemStore;
  }

  public ItemStore getItemStore() {
    return itemStore;
  }

  public int getAveragePrice() {
    List<Item> items = itemStore.readAllItems();

    int sumOfPrices = 0;
    for (Item item : items) {
      sumOfPrices += item.getPrice();
    }

    return (sumOfPrices / items.size());
  }

  public String getItemNameUpperCase(long itemId) {

    Item item = itemStore.findById(itemId);

    return StringUtils.upperCase(item.getName());
  }
}
