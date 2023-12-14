package Logic.Graph;

import Logic.CenterMass;
import processing.core.*;

public class GraphManager {
  PApplet p;
  GraphBackground gb;
  NewtonianGraph ng;
  GraphOfRealVelocity grv;
  CenterMass centerMass;

  public GraphManager(PApplet p, CenterMass centerMass) {
    this.p = p;
    this.centerMass = centerMass;
    gb = new GraphBackground(p);
    ng = new NewtonianGraph(p, centerMass);
    grv = new GraphOfRealVelocity(p, gb);
  }

  public void run() {
    gb.show();
    ng.drawGraph(centerMass, gb);
    grv.draw();

  }

}
