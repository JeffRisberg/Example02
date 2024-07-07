package com.company;

import com.company.models.Item;
import com.company.services.ItemService;
import com.company.stores.ItemStore;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ItemServiceTest {

  private ItemService itemService;
  private ItemStore itemStore;

  @Before
  public void setUp() throws Exception {
    Injector injector = Guice.createInjector(new MockAppModule());

    itemService = injector.getInstance(ItemService.class);
    itemStore = itemService.getItemStore(); // will be a mock object
  }

  @Test
  public void getItemById() {
    //
    // When
    //
    Item result = itemService.getById(1L);

    //
    // Verify
    //
    verify(itemStore, times(1)).findById(1L);
    assertEquals(result.getName(), "Item 1");
  }

  @Test
  public void getItemNameUpperCase() {
    //
    // Test
    //
    String result = itemService.getItemNameUpperCase(1L);

    //
    // Verify
    //
    verify(itemStore, times(1)).findById(1L);
    assertEquals("ITEM 1", result);
  }

  @Test
  public void getAveragePrice() {
    //
    // Test
    //
    int result = itemService.getAveragePrice();

    //
    // Verify
    //
    verify(itemStore, times(1)).readAllItems();
    assertEquals(3000, result);
  }
}
