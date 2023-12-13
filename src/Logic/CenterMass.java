package Logic;

import processing.core.*;

public class CenterMass {
  PApplet p;
  int radius;
  double mass;
  PVector position;
  int colour;

  public CenterMass(PApplet p, int r, double m, int c) {
    this.p = p;
    radius = r;
    mass = m * 1.989e30;
    colour = c;
    position = new PVector(p.width / 2, p.height / 2);
  }

  public void show() {
    p.fill(colour);
    p.circle(position.x, position.y, radius);
  }
}
