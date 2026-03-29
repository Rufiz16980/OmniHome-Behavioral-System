package com.omnihome.command;

public interface Command {
  void execute();

  void undo();
}
