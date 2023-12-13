package Logic;

import processing.core.*;

public class CenterMass {
  PApplet p;
  int radius;
  double mass;
  PVector position;

  public CenterMass(PApplet p, int r, double m) {
    this.p = p;
    radius = r;
    mass = m * 1.989e30;

    position = new PVector(p.width / 2, p.height / 2);
  }

  public void show() {
    p.circle(position.x, position.y, radius);
  }
}
