package com.company;

import com.company.models.Item;
import com.company.stores.ItemStore;

import java.util.ArrayList;
import java.util.List;

public class MockItemStore implements ItemStore {

  Item item1 = new Item(1L, "Item 1", "", 2000);
  Item item2 = new Item(1L, "Item 2", "", 4000);

  List<Item> items;

  public MockItemStore() {
    items = new ArrayList<Item>();

    items.add(item1);
    items.add(item2);
  }

  public List readAllItems() {
    return items;
  }

  public Item findById(long id) {
    for (Item item : items) {
      if (item.getId() == id)
        return item;
    }
    return null;
  }
}
