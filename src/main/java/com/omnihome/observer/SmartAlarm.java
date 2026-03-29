package com.omnihome.observer;

import com.omnihome.strategy.AlertStrategy;
import com.omnihome.strategy.LoudSirenStrategy;
import com.omnihome.strategy.SilentPushStrategy;
import java.util.HashMap;
import java.util.Map;

public class SmartAlarm implements Observer {
  private final Map<String, AlertStrategy> alertStrategies;
  private AlertStrategy currentStrategy;
  private boolean motionDetected;
  private int alertCount;
  private boolean armed;
  private String lastAlertMessage;

  public SmartAlarm() {
    alertStrategies = new HashMap<>();
    registerStrategy("SILENT", new SilentPushStrategy());
    registerStrategy("SIREN", new LoudSirenStrategy());
    setAlertStrategy("SILENT");
  }

  @Override
  public void update() {
    motionDetected = true;
    alertCount++;
    lastAlertMessage = currentStrategy.executeAlert();
    System.out.println(lastAlertMessage);
  }

  public void registerStrategy(String securityLevel, AlertStrategy strategy) {
    alertStrategies.put(securityLevel, strategy);
  }

  public void setAlertStrategy(String securityLevel) {
    AlertStrategy selectedStrategy = alertStrategies.get(securityLevel);

    if (selectedStrategy == null) {
      throw new IllegalArgumentException("Unknown security level: " + securityLevel);
    }

    currentStrategy = selectedStrategy;
  }

  public Map<String, AlertStrategy> getAlertStrategyRegistry() {
    return alertStrategies;
  }

  public boolean hasDetectedMotion() {
    return motionDetected;
  }

  public int getAlertCount() {
    return alertCount;
  }

  public String getLastAlertMessage() {
    return lastAlertMessage;
  }

  public boolean isArmed() {
    return armed;
  }

  public void arm() {
    armed = true;
    System.out.println("Smart alarm armed.");
  }

  public void disarm() {
    armed = false;
    System.out.println("Smart alarm disarmed.");
  }

  public void resetMotionDetection() {
    motionDetected = false;
    lastAlertMessage = null;
  }
}
