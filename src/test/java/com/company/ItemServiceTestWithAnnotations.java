package com.company;

import com.company.models.Item;
import com.company.services.ItemService;
import com.company.stores.ItemStore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTestWithAnnotations {

  @Mock
  private ItemStore itemStore;

  @InjectMocks
  private ItemService itemService;

  @Before
  public void setUp() throws Exception {
    Item mockedItem1 = new Item(1L, "Item 1", "This is item 1", 2000);
    Item mockedItem2 = new Item(2L, "Item 2", "This is item 2", 4000);
    List<Item> mockedItems = new ArrayList<>();
    mockedItems.add(mockedItem1);
    mockedItems.add(mockedItem2);

    when(itemStore.readAllItems()).thenReturn(mockedItems);

    when(itemStore.findById(1L)).thenReturn(mockedItem1);
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
    assertThat(result, is("ITEM 1"));
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
