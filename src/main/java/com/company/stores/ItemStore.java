package com.company.stores;

import com.company.models.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemStore {

   List readAllItems();

   Item findById(long id);
}
