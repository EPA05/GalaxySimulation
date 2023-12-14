package Logic;

import processing.core.*;

public class Star {
  PApplet p;
  CenterMass centerMass;
  int radius;
  double distance;
  PVector position;
  double pixelDistance;
  int colour;
  double kpcToMeters = 3.0857e19;

  public Star(PApplet p, Double d, int c) {
    this.p = p;
    distance = d * kpcToMeters;
    colour = c;
    radius = 15;
    pixelDistance = p.height / 2 / (7.3 * kpcToMeters);
    position = new PVector((float) (p.width / 2 + distance * pixelDistance), p.height / 2);

  }

  public void show() {
    p.fill(colour);
    p.circle(position.x, position.y, radius);
  }

  public void velocityCalculate() {
    double G = 6.674e-11;
    double velocity = Math.sqrt(G * centerMass.mass / distance);
    System.out.println(velocity);
  }

}
