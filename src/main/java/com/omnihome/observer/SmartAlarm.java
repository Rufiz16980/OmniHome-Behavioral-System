package com.omnihome.observer;

public class SmartAlarm implements Observer {
  private boolean motionDetected;
  private int alertCount;

  @Override
  public void update() {
    motionDetected = true;
    alertCount++;
    System.out.println("Smart alarm detected motion and is ready to respond.");
  }

  public boolean hasDetectedMotion() {
    return motionDetected;
  }

  public int getAlertCount() {
    return alertCount;
  }

  public void resetMotionDetection() {
    motionDetected = false;
  }
}
