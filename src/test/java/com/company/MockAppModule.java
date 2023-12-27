package com.company;

import com.company.models.Item;
import com.company.stores.ItemStore;
import com.google.inject.AbstractModule;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockAppModule extends AbstractModule {

  @Override
  protected void configure() {
    ItemStore mockItemStore = mock(ItemStore.class);

    Item mockedItem1 = new Item(1L, "Item 1", "This is item 1", 2000);
    Item mockedItem2 = new Item(2L, "Item 2", "This is item 2", 4000);
    List<Item> mockedItems = new ArrayList<>();
    mockedItems.add(mockedItem1);
    mockedItems.add(mockedItem2);

    when(mockItemStore.readAllItems()).thenReturn(mockedItems);

    when(mockItemStore.findById(1L)).thenReturn(mockedItem1);

    when(mockItemStore.findById(2L)).thenReturn(mockedItem2);

    bind(ItemStore.class).toInstance(mockItemStore);
  }
}
