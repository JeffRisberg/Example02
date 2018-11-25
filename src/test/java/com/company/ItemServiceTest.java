package com.company;

import com.company.services.ItemService;
import com.company.stores.ItemStore;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

  private ItemService itemService;
  private ItemStore itemStore;

  @Before
  public void setUp() throws Exception {
    Injector injector = Guice.createInjector(new MockAppModule());

    itemService = injector.getInstance(ItemService.class);
    itemStore = itemService.getItemStore();
  }

  @Test
  public void getItemNameUpperCase() {
    ItemStore spyItemStore = Mockito.spy(itemStore);
    //
    // When
    //
    String result = itemService.getItemNameUpperCase(1L);

    //
    // Then
    //
    verify(spyItemStore, times(1)).findById(1L);
    assertEquals("ITEM 1", result);
  }

  @Test
  public void getAveragePrice() {
    ItemStore spyItemStore = Mockito.spy(itemStore);

    //
    // When
    //
    int result = itemService.getAveragePrice();

    verify(spyItemStore, times(1)).readAllItems();
    assertEquals(3000, result);
  }
}
