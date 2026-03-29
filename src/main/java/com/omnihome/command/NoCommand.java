package com.omnihome.command;

public class NoCommand implements Command {
  @Override
  public void execute() {
    System.out.println("No command assigned to this slot.");
  }

  @Override
  public void undo() {
    System.out.println("Nothing to undo.");
  }
}
