package com.omnihome;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class MainSimulationTest {

  @Test
  void mainRunsRequiredAssignmentSequence() {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();

    try {
      System.setOut(new PrintStream(capturedOutput, true, StandardCharsets.UTF_8));

      Main.main(new String[0]);

      String output = capturedOutput.toString(StandardCharsets.UTF_8);
      assertTrue(output.contains("Testing Event Bus & Strategy"));
      assertTrue(output.contains("Motion detected by sensor."));
      assertTrue(output.contains("Sending silent push notification to homeowner's phone."));
      assertTrue(output.contains("SOUNDING 120dB SIREN!"));
      assertTrue(output.contains("Testing Remote & Command"));
      assertTrue(output.contains("Smart lights turned on."));
      assertTrue(output.contains("Smart alarm armed."));
      assertTrue(output.contains("Smart alarm disarmed."));
    } finally {
      System.setOut(originalOut);
    }
  }
}
