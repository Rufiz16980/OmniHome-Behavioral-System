package com.omnihome;

import com.omnihome.command.ArmAlarmCommand;
import com.omnihome.command.SmartRemote;
import com.omnihome.command.TurnOnLightCommand;
import com.omnihome.observer.MotionSensor;
import com.omnihome.observer.SmartAlarm;
import com.omnihome.observer.SmartLights;

public class Main {
  public static void main(String[] args) {
    MotionSensor motionSensor = new MotionSensor();
    SmartLights smartLights = new SmartLights();
    SmartAlarm smartAlarm = new SmartAlarm();

    System.out.println("Testing Event Bus & Strategy");
    smartAlarm.setAlertStrategy("SILENT");
    motionSensor.addObserver(smartLights);
    motionSensor.addObserver(smartAlarm);
    motionSensor.detectMotion();

    smartAlarm.setAlertStrategy("SIREN");
    motionSensor.detectMotion();

    System.out.println("Testing Remote & Command");
    SmartRemote smartRemote = new SmartRemote(2);
    smartRemote.setCommand(0, new TurnOnLightCommand(smartLights));
    smartRemote.setCommand(1, new ArmAlarmCommand(smartAlarm));

    smartRemote.pressButton(0);
    smartRemote.pressButton(1);
    smartRemote.pressUndo();
  }
}
