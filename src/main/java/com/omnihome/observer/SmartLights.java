package com.omnihome.observer;

public class SmartLights implements Observer {
  private boolean on;
  private int activationCount;

  @Override
  public void update() {
    turnOn();
    System.out.println("Smart lights turned on due to motion.");
  }

  public boolean isOn() {
    return on;
  }

  public int getActivationCount() {
    return activationCount;
  }

  public void turnOn() {
    on = true;
    activationCount++;
    System.out.println("Smart lights turned on.");
  }

  public void turnOff() {
    on = false;
    System.out.println("Smart lights turned off.");
  }
}
