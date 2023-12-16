package Logic.Graph;

import processing.core.PApplet;
import processing.core.PShape;
import Logic.Star;
import cern.jet.math.Bessel;

public class VisibleDiskGraph {
  PApplet p;
  NewtonianGraph ng;
  GraphBackground gb;
  Star s;
  float r;
  float v;
  float v_disk;
  private boolean graphCalculated = false;
  private PShape graphShape;

  public VisibleDiskGraph(PApplet p, NewtonianGraph ng, Star s) {
    this.p = p;
    this.ng = ng;
    this.s = s;

  }

  public void drawGraph(GraphBackground gb) {
    p.stroke(255, 0, 255); // Set stroke color to magenta
    p.noFill();

    if (!graphCalculated) {
      graphShape = p.createShape();
      graphShape.beginShape();
      for (r = (float) (0.01 * s.kpcToKm); r < 30 * s.kpcToKm; r += 0.01 * s.kpcToKm) {
        double y = r / (2 * s.R_D);

        double i0 = Bessel.i0(y);
        double i1 = Bessel.i1(y);
        double k0 = Bessel.k0(y);
        double k1 = Bessel.k1(y);

        double result = i0 * k0 - i1 * k1;

        v_disk = (float) Math.sqrt((4 * Math.PI * s.G_km * s.SIGMA_0 * s.R_D * y * y * result));
        float rInKpc = (float) (r * 3.2408e-17);
        float mappedV = PApplet.map(v_disk, 0, 250, 0, gb.graphHeight - 2 * gb.distanceFromEdge);
        float mappedR = PApplet.map(rInKpc, 0, 30, 0, gb.graphWidth - 2 * gb.distanceFromEdge);
        graphShape.vertex(mappedR, -mappedV);
      }
      graphShape.endShape();
      graphCalculated = true;
    }
    p.pushMatrix();
    p.translate(gb.graphX + gb.distanceFromEdge, gb.graphY + gb.graphHeight - gb.distanceFromEdge);
    p.shape(graphShape);
    p.popMatrix();
    p.noStroke();
  }

}
