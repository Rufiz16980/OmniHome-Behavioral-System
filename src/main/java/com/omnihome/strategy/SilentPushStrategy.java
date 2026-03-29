package com.omnihome.strategy;

public class SilentPushStrategy implements AlertStrategy {
  @Override
  public String executeAlert() {
    return "Sending silent push notification to homeowner's phone.";
  }
}
