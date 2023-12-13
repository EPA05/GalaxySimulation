package Logic;

import processing.core.*;

public class LogicManager {
  PApplet p;
  CenterMass centerMass;

  public LogicManager(PApplet p) {
    this.p = p;
    centerMass = new CenterMass(p, 30, 5.262e10);
  }

  public void run() {
    centerMass.show();
  }
}
