package com.company;

import com.company.models.Item;
import com.company.services.ItemService;
import com.company.stores.ItemStore;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ItemServiceTest {

  @Mock
  private ItemStore itemStore;

  @InjectMocks
  private ItemService itemService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getItemNameUpperCase() {
    //
    // Given
    //
    Item mockedItem = new Item(1L, "Item 1", "This is item 1", 2000);
    when(itemStore.findById(1L)).thenReturn(mockedItem);

    //
    // When
    //
    String result = itemService.getItemNameUpperCase(1L);

    //
    // Then
    //
    verify(itemStore, times(1)).findById(1L);
    assertEquals("ITEM 1", result);
  }

  @Test
  public void getAveragePrice() {
    //
    // Given
    //
    Item mockedItem1 = new Item(1L, "Item 1", "This is item 1", 2000);
    Item mockedItem2 = new Item(2L, "Item 2", "This is item 2", 4000);
    List<Item> mockedItems = new ArrayList<>();
    mockedItems.add(mockedItem1);
    mockedItems.add(mockedItem2);

    when(itemStore.readAllItems()).thenReturn(mockedItems);

    //
    // When
    //
    int result = itemService.getAveragePrice();

    verify(itemStore, times(1)).readAllItems();
    assertEquals(3000, result);
  }
}
