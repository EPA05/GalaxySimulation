package Logic.Graph;

import Logic.Star;
import cern.jet.math.Bessel;
import processing.core.PApplet;
import processing.core.PShape;

public class DiskAndDarkMatterGraph {
  PApplet p;
  GraphBackground gb;
  Star s;
  float r; // in kpc

  private boolean graphCalculated = false; // to calculate the graph only once
  private PShape graphShape; // the shape of the graph

  public DiskAndDarkMatterGraph(PApplet p, Star s) {
    this.p = p;
    this.s = s;

  }

  // draw the velocity graph of the disk and dark matter
  public void drawGraph(GraphBackground gb) {
    p.stroke(21, 96, 189);
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

        double v_disk = (float) Math.sqrt((4 * Math.PI * s.G_km * s.SIGMA_0 * s.R_D * y * y * result));

        double v_DM = Math
            .sqrt(((4 * Math.PI * s.G_km * s.RHO_0 * Math.pow(s.r_c, 3)) / r) * (r / s.r_c - (Math.atan(r / s.r_c))));

        double v_total = Math.sqrt(Math.pow(v_disk, 2) + Math.pow(v_DM, 2));

        float rInKpc = (float) (r * 3.2408e-17);
        float mappedV = PApplet.map((float) v_total, 0, 250, 0, gb.graphHeight - 2 * gb.distanceFromEdge);
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
