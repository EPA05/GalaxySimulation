package Logic;

import processing.core.*;

public class LogicManager {
  PApplet p;
  CenterMass centerMass;
  Star[] stars;

  public LogicManager(PApplet p) {
    this.p = p;
    centerMass = new CenterMass(p, 25, 8.5e9, p.color(255, 0, 0));
    stars = new Star[28];

    stars[0] = new Star(p, 0.63, p.color(255, 255, 0), centerMass);

    stars[1] = new Star(p, 1.36, p.color(255, 255, 0), centerMass);

    stars[2] = new Star(p, 2.04, p.color(255, 255, 0), centerMass);

    stars[3] = new Star(p, 2.72, p.color(255, 255, 0), centerMass);

    stars[4] = new Star(p, 3.40, p.color(255, 255, 0), centerMass);

    stars[5] = new Star(p, 4.08, p.color(255, 255, 0), centerMass);

    stars[6] = new Star(p, 4.76, p.color(255, 255, 0), centerMass);

    stars[7] = new Star(p, 5.44, p.color(255, 255, 0), centerMass);

    stars[8] = new Star(p, 6.12, p.color(255, 255, 0), centerMass);

    stars[9] = new Star(p, 6.80, p.color(255, 255, 0), centerMass);

    stars[10] = new Star(p, 7.48, p.color(255, 255, 0), centerMass);

    stars[11] = new Star(p, 8.16, p.color(255, 255, 0), centerMass);

    stars[12] = new Star(p, 9.52, p.color(255, 255, 0), centerMass);

    stars[13] = new Star(p, 10.88, p.color(255, 255, 0), centerMass);

    stars[14] = new Star(p, 12.25, p.color(255, 255, 0), centerMass);

    stars[15] = new Star(p, 13.60, p.color(255, 255, 0), centerMass);

    stars[16] = new Star(p, 14.96, p.color(255, 255, 0), centerMass);

    stars[17] = new Star(p, 16.32, p.color(255, 255, 0), centerMass);

    stars[18] = new Star(p, 17.68, p.color(255, 255, 0), centerMass);

    stars[19] = new Star(p, 19.04, p.color(255, 255, 0), centerMass);

    stars[20] = new Star(p, 20.40, p.color(255, 255, 0), centerMass);

    stars[21] = new Star(p, 21.76, p.color(255, 255, 0), centerMass);

    stars[22] = new Star(p, 23.12, p.color(255, 255, 0), centerMass);

    stars[23] = new Star(p, 24.48, p.color(255, 255, 0), centerMass);

    stars[24] = new Star(p, 25.84, p.color(255, 255, 0), centerMass);

    stars[25] = new Star(p, 27.20, p.color(255, 255, 0), centerMass);

    stars[26] = new Star(p, 28.56, p.color(255, 255, 0), centerMass);

    stars[27] = new Star(p, 19.92, p.color(255, 255, 0), centerMass);

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

  public Star getStar() {
    return stars[0];
  }
}
