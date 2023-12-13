package Logic;

import processing.core.*;

public class Star {
  PApplet p;
  int radius;
  double distance;
  PVector position;
  double pixelConstant;
  int colour;
  double kpcToMeters = 3.0857e19;

  public Star(PApplet p, Double d, int c) {
    this.p = p;
    distance = d * kpcToMeters;
    colour = c;
    radius = 15;
    pixelConstant = p.height / 2 / (7.3 * kpcToMeters);
    position = new PVector((float) (p.width / 2 + distance * pixelConstant), p.height / 2);

  }

  public void show() {
    p.fill(colour);
    p.circle(position.x, position.y, radius);
  }

}
