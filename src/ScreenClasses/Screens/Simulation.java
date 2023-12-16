package ScreenClasses.Screens;

import processing.core.*;

import ScreenClasses.Screen;
import Logic.LogicManager;
import Logic.Graph.GraphManager;
import Logic.Visualinterface;

public class Simulation extends Screen {
  PApplet p;
  LogicManager lm;
  GraphManager gm;
  Visualinterface vi;

  Simulation(PApplet p) {
    this.p = p;
    lm = new LogicManager(p);
    gm = new GraphManager(p, lm.getCenterMass(), lm.getStar(), vi);

  }

  public void update() {
    p.background(0);
    lm.run();
    gm.run();
  }
}
