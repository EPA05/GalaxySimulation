package ScreenClasses.Screens;

import processing.core.*;

import ScreenClasses.Screen;
import Logic.LogicManager;
import Logic.Graph.GraphManager;

public class Simulation extends Screen {
  PApplet p;
  LogicManager lm;
  GraphManager gm;

  Simulation(PApplet p) {
    this.p = p;
    lm = new LogicManager(p);
    gm = new GraphManager(p);
  }

  public void update() {
    p.background(0);
    lm.run();
    gm.run();
  }
}
