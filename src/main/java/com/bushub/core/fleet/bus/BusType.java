package com.bushub.core.fleet.bus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BusType {
  REGULAR(45),
  ORDINARY(50),
  DELUXE(40),
  FIRST_CLASS(35),
  SLEEPER(30),
  CARGO(0);

  private final int seatCapacity;
}
