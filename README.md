# OmniHome-Behavioral-System

## Overview

This project implements the behavioral architecture for the OmniHome smart home scenario using three classic design patterns:

- Observer Pattern for sensor-to-device event broadcasting
- Strategy Pattern for dynamic alarm behavior switching
- Command Pattern for remote control actions with undo support

## Planned Architecture

- `Observer`: `MotionSensor` notifies subscribed smart devices
- `Strategy`: `SmartAlarm` delegates alert behavior through a registry-backed strategy lookup
- `Command`: `SmartRemote` executes device commands without depending on concrete device logic

## Tech Stack

- Java 17+
- Gradle (Groovy DSL)
- JUnit 5

## Project Layout

```text
src/
  main/java/com/omnihome/
  test/java/com/omnihome/
```

## Development Phases

1. Phase 0: Repository bootstrap and project scaffold
2. Phase 1: Observer pattern implementation
3. Phase 2: Strategy pattern implementation
4. Phase 3: Command pattern implementation
5. Phase 4: Main simulation, tests, and final cleanup

## Run and Test

Commands to use once implementation is added:

```bash
./gradlew test
./gradlew run
```

On Windows PowerShell:

```powershell
.\gradlew.bat test
.\gradlew.bat run
```

## Submission Notes

- The final submission must be a direct URL to a public GitHub repository
- Commit early and often to show architectural progress
- Push each phase separately so the commit history clearly reflects the implementation steps
