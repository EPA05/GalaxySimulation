package Logic.Graph;

import processing.core.*;
import Logic.CenterMass;

public class NewtonianGraph {
  PApplet p;
  CenterMass centerMass;
  GraphBackground gb;
  float r;
  float v;
  private boolean graphCalculated = false;
  private PShape graphShape;
  public double kpcToMeters = 3.0857e19;
  public final double G = 6.674e-11;

  public NewtonianGraph(PApplet p, CenterMass centerMass) {
    this.p = p;
    this.centerMass = centerMass;
  }

  // draw the newtonian graph
  public void drawGraph(CenterMass centerMass, GraphBackground gb) {
    p.stroke(125, 125, 125); // Set stroke color to magenta
    p.noFill();

    if (!graphCalculated) {
      graphShape = p.createShape();
      graphShape.beginShape();
      for (r = (float) (0.59 * kpcToMeters); r < 30 * kpcToMeters; r += 0.01 * kpcToMeters) {
        v = (float) (Math.sqrt((G * centerMass.mass) / r)) / 1000; // km/s
        float rInKpc = (float) (r * 3.2408e-20); // kpc
        float mappedV = PApplet.map(v, 0, 250, 0, gb.graphHeight - 2 * gb.distanceFromEdge); // km/s
        float mappedR = PApplet.map(rInKpc, 0, 30, 0, gb.graphWidth - 2 * gb.distanceFromEdge); // kpc
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
