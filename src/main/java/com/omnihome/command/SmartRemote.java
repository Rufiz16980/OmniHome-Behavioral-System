package com.omnihome.command;

import java.util.Arrays;

public class SmartRemote {
  private final Command[] commandSlots;
  private Command lastCommand;

  public SmartRemote(int slotCount) {
    commandSlots = new Command[slotCount];
    Command defaultCommand = new NoCommand();
    Arrays.fill(commandSlots, defaultCommand);
    lastCommand = defaultCommand;
  }

  public void setCommand(int slot, Command command) {
    validateSlot(slot);
    commandSlots[slot] = command;
  }

  public void pressButton(int slot) {
    validateSlot(slot);
    Command command = commandSlots[slot];
    command.execute();
    lastCommand = command;
  }

  public void pressUndo() {
    lastCommand.undo();
  }

  private void validateSlot(int slot) {
    if (slot < 0 || slot >= commandSlots.length) {
      throw new IllegalArgumentException("Invalid remote slot: " + slot);
    }
  }
}
