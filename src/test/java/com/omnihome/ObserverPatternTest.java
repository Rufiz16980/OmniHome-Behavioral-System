package com.omnihome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.omnihome.observer.MotionSensor;
import com.omnihome.observer.SmartAlarm;
import com.omnihome.observer.SmartLights;
import org.junit.jupiter.api.Test;

class ObserverPatternTest {

  @Test
  void detectMotionNotifiesAllSubscribedDevices() {
    MotionSensor motionSensor = new MotionSensor();
    SmartLights smartLights = new SmartLights();
    SmartAlarm smartAlarm = new SmartAlarm();

    motionSensor.addObserver(smartLights);
    motionSensor.addObserver(smartAlarm);

    motionSensor.detectMotion();

    assertTrue(smartLights.isOn());
    assertTrue(smartAlarm.hasDetectedMotion());
    assertEquals(1, smartLights.getActivationCount());
    assertEquals(1, smartAlarm.getAlertCount());
  }

  @Test
  void removedObserverNoLongerReceivesUpdates() {
    MotionSensor motionSensor = new MotionSensor();
    SmartLights smartLights = new SmartLights();
    SmartAlarm smartAlarm = new SmartAlarm();

    motionSensor.addObserver(smartLights);
    motionSensor.addObserver(smartAlarm);
    motionSensor.removeObserver(smartAlarm);

    motionSensor.detectMotion();

    assertTrue(smartLights.isOn());
    assertFalse(smartAlarm.hasDetectedMotion());
    assertEquals(1, smartLights.getActivationCount());
    assertEquals(0, smartAlarm.getAlertCount());
  }

  @Test
  void detectMotionCanNotifyDevicesMultipleTimes() {
    MotionSensor motionSensor = new MotionSensor();
    SmartLights smartLights = new SmartLights();
    SmartAlarm smartAlarm = new SmartAlarm();

    motionSensor.addObserver(smartLights);
    motionSensor.addObserver(smartAlarm);

    motionSensor.detectMotion();
    smartLights.turnOff();
    smartAlarm.resetMotionDetection();

    motionSensor.detectMotion();

    assertTrue(smartLights.isOn());
    assertTrue(smartAlarm.hasDetectedMotion());
    assertEquals(2, smartLights.getActivationCount());
    assertEquals(2, smartAlarm.getAlertCount());
  }
}
