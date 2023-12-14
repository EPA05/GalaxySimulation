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
  double timeConstant;
  PVector velocity;
  double angle;
  double kpcToMeters = 3.0857e19;
  final double G = 6.674e-11;

  public Star(PApplet p, Double d, int c, CenterMass centerMass) {
    this.p = p;
    this.centerMass = centerMass;
    distance = d * kpcToMeters;
    colour = c;
    radius = 15;
    pixelDistance = p.height / 2 / (7.3 * kpcToMeters);
    angle = p.random(PConstants.TWO_PI); // Generate a random angle
    position = new PVector((float) (p.width / 2 + distance * pixelDistance * Math.cos(angle)),
        (float) (p.height / 2 + distance * pixelDistance * Math.sin(angle)));
    timeConstant = (60 * 60 * 24 * 365 * 1e6) / p.frameRate;
    velocity = new PVector(0, 0);
  }

  public void show() {
    p.fill(colour);
    p.circle(position.x, position.y, radius);
  }

  public void update() {
    for (int i = 0; i < 100; i++) {
      velocity(centerMass);
      position.add(PVector.mult(velocity, (float) timeConstant));
    }

  }

  public void velocity(CenterMass centerMass) {
    double orbitalSpeed = Math.sqrt((G * centerMass.mass) / (distance)); // Calculate the orbital speed of the planet
    PVector directionToSun = PVector.sub(centerMass.position, position); // Vector from planet to sun
    directionToSun.normalize(); // Normalize to get a unit vector
    PVector VelocityDirection = directionToSun.rotate(PConstants.HALF_PI); // Rotate 90 degrees to get a
    // perpendicular
    velocity = VelocityDirection.mult((float) orbitalSpeed); // Calculate the velocity of the planet
    velocity.mult((float) pixelDistance); // Convert velocity from m/s to pixels/s
  }

}
