package com.omnihome.command;

import com.omnihome.observer.SmartAlarm;

public class ArmAlarmCommand implements Command {
  private final SmartAlarm smartAlarm;

  public ArmAlarmCommand(SmartAlarm smartAlarm) {
    this.smartAlarm = smartAlarm;
  }

  @Override
  public void execute() {
    smartAlarm.arm();
  }

  @Override
  public void undo() {
    smartAlarm.disarm();
  }
}
