package com.omnihome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.omnihome.observer.SmartAlarm;
import org.junit.jupiter.api.Test;

class StrategyPatternTest {

  @Test
  void smartAlarmUsesSilentStrategyWhenConfigured() {
    SmartAlarm smartAlarm = new SmartAlarm();

    smartAlarm.setAlertStrategy("SILENT");
    smartAlarm.update();

    assertEquals(
        "Sending silent push notification to homeowner's phone.",
        smartAlarm.getLastAlertMessage());
  }

  @Test
  void smartAlarmCanSwapToSirenStrategyAtRuntime() {
    SmartAlarm smartAlarm = new SmartAlarm();

    smartAlarm.setAlertStrategy("SILENT");
    smartAlarm.update();
    smartAlarm.resetMotionDetection();

    smartAlarm.setAlertStrategy("SIREN");
    smartAlarm.update();

    assertEquals("SOUNDING 120dB SIREN!", smartAlarm.getLastAlertMessage());
    assertEquals(2, smartAlarm.getAlertCount());
  }

  @Test
  void smartAlarmStoresStrategiesInRegistryForConstantTimeLookup() {
    SmartAlarm smartAlarm = new SmartAlarm();

    assertTrue(smartAlarm.getAlertStrategyRegistry().containsKey("SILENT"));
    assertTrue(smartAlarm.getAlertStrategyRegistry().containsKey("SIREN"));
    assertEquals(2, smartAlarm.getAlertStrategyRegistry().size());
  }

  @Test
  void unknownSecurityLevelThrowsHelpfulException() {
    SmartAlarm smartAlarm = new SmartAlarm();

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> smartAlarm.setAlertStrategy("LOCKDOWN"));

    assertEquals("Unknown security level: LOCKDOWN", exception.getMessage());
  }
}
