package ScreenClasses.Screens;

import processing.core.*;

import ScreenClasses.Screen;
import Logic.LogicManager;

public class Simulation extends Screen {
  LogicManager lm;
  PApplet p;

  Simulation(PApplet p) {
    this.p = p;
    lm = new LogicManager(p);
  }

  public void update() {
    p.background(0);
    lm.run();
  }
}
