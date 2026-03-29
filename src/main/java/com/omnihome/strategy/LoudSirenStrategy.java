package com.omnihome.strategy;

public class LoudSirenStrategy implements AlertStrategy {
  @Override
  public String executeAlert() {
    return "SOUNDING 120dB SIREN!";
  }
}
