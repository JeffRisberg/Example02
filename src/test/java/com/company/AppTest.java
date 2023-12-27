package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit test for simple App.
 */
public class AppTest {

  @Test
  public void testAppConstructor() {
    try {
      new App();
    } catch (Exception e) {
      fail("Construction failed.");
    }
  }

  @Test
  public void testAppMain() {
    int averagePrice = new App().getAveragePrice();

    assertEquals(41, averagePrice);
  }
}
