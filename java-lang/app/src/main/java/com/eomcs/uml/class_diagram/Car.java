package com.eomcs.uml.class_diagram;

public class Car {
  Engine engine;
  Insurance insurance;
  Navigation navigation;

  // Composition 합성 관계
  public Car(Engine engine) {
    this.engine = engine;
  }

  // Association 연관 관계
  public Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  // Aggregation 집합 관계
  public Navigation getNavigation() {
    return navigation;
  }

  public void setNavigation(Navigation navigation) {
    this.navigation = navigation;
  }

  public Engine getEngine() {
    return engine;
  }

  // Dependency 의존 관계
  public void fuelUp(GasStation gasStation) {
    gasStation.inject();
  }
}
