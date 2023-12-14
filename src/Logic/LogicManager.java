package Logic;

import processing.core.*;

public class LogicManager {
  PApplet p;
  CenterMass centerMass;
  Star[] stars;

  public LogicManager(PApplet p) {
    this.p = p;
    centerMass = new CenterMass(p, 30, 2.19e8, p.color(255, 0, 0));
    stars = new Star[16];

    stars[0] = new Star(p, 0.45, p.color(255, 255, 0), centerMass);

    stars[1] = new Star(p, 0.9, p.color(255, 255, 0), centerMass);

    stars[2] = new Star(p, 1.35, p.color(255, 255, 0), centerMass);

    stars[3] = new Star(p, 1.80, p.color(255, 255, 0), centerMass);

    stars[4] = new Star(p, 2.25, p.color(255, 255, 0), centerMass);

    stars[5] = new Star(p, 2.69, p.color(255, 255, 0), centerMass);

    stars[6] = new Star(p, 3.14, p.color(255, 255, 0), centerMass);

    stars[7] = new Star(p, 3.59, p.color(255, 255, 0), centerMass);

    stars[8] = new Star(p, 4.04, p.color(255, 255, 0), centerMass);

    stars[9] = new Star(p, 4.49, p.color(255, 255, 0), centerMass);

    stars[10] = new Star(p, 4.94, p.color(255, 255, 0), centerMass);

    stars[11] = new Star(p, 5.39, p.color(255, 255, 0), centerMass);

    stars[12] = new Star(p, 5.84, p.color(255, 255, 0), centerMass);

    stars[13] = new Star(p, 6.29, p.color(255, 255, 0), centerMass);

    stars[14] = new Star(p, 6.74, p.color(255, 255, 0), centerMass);

    stars[15] = new Star(p, 7.19, p.color(255, 255, 0), centerMass);

  }

  public void run() {
    centerMass.show();

    for (Star stars : stars) {
      stars.show();
      stars.update();
    }
  }

  public CenterMass getCenterMass() {
    return centerMass;
  }
}
