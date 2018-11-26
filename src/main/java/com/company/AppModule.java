package com.company;

import com.company.stores.ItemStore;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ItemStore.class);
  }
}
