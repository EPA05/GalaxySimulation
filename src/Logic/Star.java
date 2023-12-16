package Logic;

import processing.core.*;

import cern.jet.math.Bessel;

public class Star {
  PApplet p;
  CenterMass centerMass;
  Visualinterface vi;

  int radius;
  double distance;
  PVector position;
  double pixelDistance;
  double pixelDistanceKm;
  int colour;
  double timeConstant;
  PVector velocity;
  double angle;
  double gamma = 0.5;
  double I_0; // solLum/pc2
  double v_disk;
  double v_DM;
  double v_total;
  double r;
  double speed;
  public double R_D;
  public double r_c;
  public double SIGMA_0;
  public double RHO_0;
  public double kpcToMeters = 3.0857e19;
  public double kpcToKm = 3.0857e16;
  final double G = 6.674e-11; // m^3/kg*s^2
  public final double G_km = 6.674e-20; // km^3/kg*s^2

  public Star(PApplet p, Double d, int c, CenterMass centerMass, Visualinterface vi) {
    this.p = p;
    this.centerMass = centerMass;
    this.vi = vi;
    distance = d;
    colour = c;
    radius = 10;
    pixelDistance = p.height / 2 / (30 * kpcToMeters);
    pixelDistanceKm = p.height / 2 / (30 * kpcToKm);
    angle = p.random(PConstants.TWO_PI); // Generate a random angle

    r = distance * kpcToKm;
    r_c = 6.5 * kpcToKm;
    R_D = 2.5 * kpcToKm;
    I_0 = 1602.62 * 1e6; // solLum/kpc^2
    SIGMA_0 = (gamma * I_0 * 1.989e30) / (Math.pow(kpcToKm, 2)); // kg/kpc^2
    RHO_0 = (1.1e7 * 1.989e30) / Math.pow(kpcToKm, 3); // kg/kpc^3

    position = new PVector((float) (p.width / 2 + distance * kpcToMeters * pixelDistance * Math.cos(angle)),
        (float) (p.height / 2 + distance * kpcToMeters * pixelDistance * Math.sin(angle)));
    timeConstant = (60 * 60 * 24 * 365 * 1e6) / p.frameRate;
    velocity = new PVector(0, 0);
  }

  public void show() {
    p.fill(colour);
    p.circle(position.x, position.y, radius);
  }

  public void update() {
    applyVelocity(vi);
  }

  double newtonsVelocity(CenterMass centerMass) {
    double orbitalSpeed = Math.sqrt((G * centerMass.mass) / (distance * kpcToMeters)); // Calculate the orbital speed of
                                                                                       // // the plane
    speed = orbitalSpeed / 1000; // Convert from m/s to km/s
    return speed;
  }

  double getVisibleDiskVelocity() {

    double y = r / (2 * R_D);

    double i0 = Bessel.i0(y);
    double i1 = Bessel.i1(y);
    double k0 = Bessel.k0(y);
    double k1 = Bessel.k1(y);

    double result = i0 * k0 - i1 * k1;

    v_disk = Math.sqrt((4 * Math.PI * G_km * SIGMA_0 * R_D * y * y * result));
    speed = v_disk;
    return speed;
  }

  double getDarkMatteVelocity() {
    v_DM = Math.sqrt(((4 * Math.PI * G_km * RHO_0 * Math.pow(r_c, 3)) / r) * (r / r_c - (Math.atan(r / r_c))));
    speed = v_DM;
    return speed;
  }

  double getDiskAndDarkMatterVelocity() {
    v_disk = getVisibleDiskVelocity();
    v_DM = getDarkMatteVelocity();
    v_total = Math.sqrt(Math.pow(v_disk, 2) + Math.pow(v_DM, 2));
    speed = v_total;
    return speed;
  }

  void applyVelocity(Visualinterface vi) {

    if (vi.GetIsPressed1()) {
      speed = 0;
      newtonsVelocity(centerMass);
    } else if (vi.GetIsPressed2()) {
      speed = 0;
      getVisibleDiskVelocity();
    } else if (vi.GetIsPressed3()) {
      speed = 0;
      getDarkMatteVelocity();
    } else if (vi.GetIsPressed4()) {
      speed = 0;
      getDiskAndDarkMatterVelocity();
    }

    PVector directionToSun = PVector.sub(centerMass.position, position); // Vector from planet to sun
    directionToSun.normalize(); // Normalize to get a unit vector
    PVector VelocityDirection = directionToSun.rotate(PConstants.HALF_PI); // Rotate 90 degrees to get a
    velocity = VelocityDirection.mult((float) speed); // Calculate the velocity of the planet
    velocity.mult((float) pixelDistanceKm); // Convert velocity from m/s to pixels/s

    for (int i = 0; i < 10; i++) {
      position.add(PVector.mult(velocity, (float) timeConstant));
    }

  }
}
