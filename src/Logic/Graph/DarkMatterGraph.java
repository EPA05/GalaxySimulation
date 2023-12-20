package Logic.Graph;

import processing.core.PApplet;
import processing.core.PShape;
import Logic.Star;

public class DarkMatterGraph {
  PApplet p;
  GraphBackground gb;
  Star s;
  float r; // in kpc

  private boolean graphCalculated = false; // to calculate the graph only once
  private PShape graphShape; // the shape of the graph

  public DarkMatterGraph(PApplet p, Star s) {
    this.p = p;
    this.s = s;

  }

  public void drawGraph(GraphBackground gb) {
    p.stroke(255, 0, 255);
    p.noFill();

    if (!graphCalculated) {
      graphShape = p.createShape();
      graphShape.beginShape();
      for (r = (float) (0.01 * s.kpcToKm); r < 30 * s.kpcToKm; r += 0.01 * s.kpcToKm) {
        double v_DM = Math
            .sqrt(((4 * Math.PI * s.G_km * s.RHO_0 * Math.pow(s.r_c, 3)) / r) * (r / s.r_c - (Math.atan(r / s.r_c))));
        float rInKpc = (float) (r * 3.2408e-17);
        float mappedV = PApplet.map((float) v_DM, 0, 250, 0, gb.graphHeight - 2 * gb.distanceFromEdge);
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
