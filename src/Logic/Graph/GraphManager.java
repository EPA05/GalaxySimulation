package Logic.Graph;

import Logic.CenterMass;
import processing.core.*;
import Logic.Star;

public class GraphManager {
  PApplet p;
  GraphBackground gb;
  NewtonianGraph ng;
  GraphOfRealVelocity grv;
  CenterMass centerMass;
  VisibleDiskGraph vdg;
  Star s;

  public GraphManager(PApplet p, CenterMass centerMass, Star s) {
    this.p = p;
    this.centerMass = centerMass;
    this.s = s;
    gb = new GraphBackground(p);
    ng = new NewtonianGraph(p, centerMass);
    grv = new GraphOfRealVelocity(p, gb);
    vdg = new VisibleDiskGraph(p, ng, s);
  }

  public void run() {
    gb.show();
    ng.drawGraph(centerMass, gb);
    grv.draw();
    vdg.drawGraph(gb);
  }
}
