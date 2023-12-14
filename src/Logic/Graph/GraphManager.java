package Logic.Graph;

import Logic.CenterMass;
import Logic.LogicManager;
import processing.core.*;

public class GraphManager {
  PApplet p;
  GraphBackground gb;
  NewtonianGraph ng;
  CenterMass centerMass;

  public GraphManager(PApplet p, CenterMass centerMass) {
    this.p = p;
    this.centerMass = centerMass;
    gb = new GraphBackground(p);
    ng = new NewtonianGraph(p, centerMass);
  }

  public void run() {
    gb.show();
    ng.drawGraph(centerMass, gb);
  }

}
