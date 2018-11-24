package com.company;

import com.company.services.ItemService;
import com.company.stores.ItemStore;
import com.google.inject.AbstractModule;
import com.google.inject.binder.ScopedBindingBuilder;

public class MockAppModule extends AbstractModule {

  @Override
  protected void configure() {
     bind(ItemStore.class).toInstance(new MockItemStore());
  }
}
