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
  double R_D;
  double SIGMA_0;
  double gamma = 0.5;
  Double I_0; // solLum/pc2
  double v_disk;
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

    R_D = 0.61 * kpcToMeters;

    I_0 = 115.04; // solLum/pc2
    SIGMA_0 = gamma * I_0;

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
    for (int i = 0; i < 30; i++) {
      newtonsVelocity(centerMass);
      position.add(PVector.mult(velocity, (float) timeConstant));
    }

  }

  void newtonsVelocity(CenterMass centerMass) {
    double orbitalSpeed = Math.sqrt((G * centerMass.mass) / (distance)); // Calculate the orbital speed of the planet
    PVector directionToSun = PVector.sub(centerMass.position, position); // Vector from planet to sun
    directionToSun.normalize(); // Normalize to get a unit vector
    PVector VelocityDirection = directionToSun.rotate(PConstants.HALF_PI); // Rotate 90 degrees to get a
    // perpendicular
    velocity = VelocityDirection.mult((float) orbitalSpeed); // Calculate the velocity of the planet
    velocity.mult((float) pixelDistance); // Convert velocity from m/s to pixels/s
  }

  void visibleDiskVelocity() {

    double r = distance;

    double i0 = BesselFunctions.bessi0(r, R_D);
    double i1 = BesselFunctions.bessi1(r, R_D);
    double k0 = BesselFunctions.besselk0(r, R_D);
    double k1 = BesselFunctions.besselk1(r, R_D);

    double result = i0 * k0 - i1 * k1;

    // Use the result as needed
  }

  double[] calculateBesselK(double y) {
    double[] besselK = new double[2];
    besselK[0] = BesselK.value(0, -y);
    besselK[1] = BesselK.value(1, -y);
    return besselK;
  }

}
