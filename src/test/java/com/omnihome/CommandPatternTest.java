package com.omnihome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.omnihome.command.ArmAlarmCommand;
import com.omnihome.command.SmartRemote;
import com.omnihome.command.TurnOnLightCommand;
import com.omnihome.observer.SmartAlarm;
import com.omnihome.observer.SmartLights;
import org.junit.jupiter.api.Test;

class CommandPatternTest {

  @Test
  void smartRemoteExecutesLightCommandWithoutKnowingReceiverDetails() {
    SmartLights smartLights = new SmartLights();
    SmartRemote smartRemote = new SmartRemote(2);

    smartRemote.setCommand(0, new TurnOnLightCommand(smartLights));
    smartRemote.pressButton(0);

    assertTrue(smartLights.isOn());
  }

  @Test
  void smartRemoteCanArmAlarmAndUndoLastAction() {
    SmartAlarm smartAlarm = new SmartAlarm();
    SmartRemote smartRemote = new SmartRemote(2);

    smartRemote.setCommand(1, new ArmAlarmCommand(smartAlarm));
    smartRemote.pressButton(1);
    assertTrue(smartAlarm.isArmed());

    smartRemote.pressUndo();

    assertFalse(smartAlarm.isArmed());
  }

  @Test
  void pressingInvalidButtonThrowsHelpfulException() {
    SmartRemote smartRemote = new SmartRemote(2);

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> smartRemote.pressButton(3));

    assertTrue(exception.getMessage().contains("Invalid remote slot"));
  }
}
