package Logic;

import processing.core.*;

public class LogicManager {
  PApplet p;
  CenterMass centerMass;
  Star star;

  public LogicManager(PApplet p) {
    this.p = p;
    centerMass = new CenterMass(p, 30, 2.19e8, p.color(255, 0, 0));
    star = new Star(p, 0.45, p.color(255, 255, 0));

  }

  public void run() {
    centerMass.show();
    star.show();
  }
}
