package Logic.Graph;

import Logic.CenterMass;
import processing.core.*;
import Logic.Star;
import Logic.Visualinterface;

public class GraphManager {
  PApplet p;
  GraphBackground gb;
  NewtonianGraph ng;
  GraphOfRealVelocity grv;
  CenterMass centerMass;
  VisibleDiskGraph vdg;
  Star s;
  DarkMatterGraph dmg;
  DiskAndDarkMatterGraph dadmg;
  GraphInformation gi;

  public GraphManager(PApplet p, CenterMass centerMass, Star s, Visualinterface vi) {
    this.p = p;
    this.centerMass = centerMass;
    this.s = s;
    gb = new GraphBackground(p);
    ng = new NewtonianGraph(p, centerMass);
    grv = new GraphOfRealVelocity(p, gb);
    vdg = new VisibleDiskGraph(p, ng, s);
    dmg = new DarkMatterGraph(p, s);
    dadmg = new DiskAndDarkMatterGraph(p, s);
    gi = new GraphInformation(p);
  }

  public void run() {
    gb.show();
    gi.show();

    if (gi.GetIsPressed1()) {
      ng.drawGraph(centerMass, gb);
    }

    if (gi.GetIsPressed2()) {
      vdg.drawGraph(gb);
    }

    if (gi.GetIsPressed3()) {
      dmg.drawGraph(gb);
    }

    if (gi.GetIsPressed4()) {
      dadmg.drawGraph(gb);
    }

    grv.draw();
  }
}
