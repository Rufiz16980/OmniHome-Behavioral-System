package com.omnihome.command;

import com.omnihome.observer.SmartLights;

public class TurnOnLightCommand implements Command {
  private final SmartLights smartLights;

  public TurnOnLightCommand(SmartLights smartLights) {
    this.smartLights = smartLights;
  }

  @Override
  public void execute() {
    smartLights.turnOn();
  }

  @Override
  public void undo() {
    smartLights.turnOff();
  }
}
