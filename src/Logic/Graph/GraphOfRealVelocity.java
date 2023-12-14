package Logic.Graph;

import org.apache.commons.math3.fitting.WeightedObservedPoints;
import processing.core.*;

public class GraphOfRealVelocity {
  PApplet p;
  GraphBackground gb;
  private boolean graphCalculated = false;
  private PShape graphShape;

  // Define your points
  double[][] data = { { 0.45, 8.41 }, { 0.90, 17.80 }, { 1.35, 26.00 }, { 1.80, 30.90 }, { 2.25, 34.70 },
      { 2.69, 38.80 }, { 3.14, 42.50 }, { 3.59, 45.60 }, { 4.04, 48.80 }, { 4.49, 51.80 }, { 4.94, 54.80 },
      { 5.39, 56.60 }, { 5.84, 58.40 }, { 6.29, 58.50 }, { 6.74, 57.70 }, { 7.19, 57.30 } };

  GraphOfRealVelocity(PApplet p, GraphBackground gb) {
    this.p = p;
    this.gb = gb;
  }

  public void draw() {
    drawGraph(gb);
  }

  public void drawGraph(GraphBackground gb) {
    p.stroke(0, 255, 0); // Set stroke color to magenta
    p.noFill();

    WeightedObservedPoints points = new WeightedObservedPoints();

    for (double[] point : data) {
      points.add(point[0], point[1]);
    }

    if (!graphCalculated) {
      graphShape = p.createShape();
      graphShape.beginShape();
      for (int i = 0; i < data.length; i++) {
        float x = PApplet.map((float) data[i][0], (float) 0.45, 8, 0, gb.graphWidth - 2 * gb.distanceFromEdge);
        float v = PApplet.map((float) data[i][1], (float) 8.41, 60, 0, gb.graphHeight - 2 * gb.distanceFromEdge);
        graphShape.vertex(x, -v);

      }
      graphShape.endShape();
      graphCalculated = true;
    }

    p.pushMatrix();
    p.translate(gb.graphX + gb.distanceFromEdge, gb.graphY + gb.graphHeight - gb.distanceFromEdge);
    p.shape(graphShape);
    drawRealVelocities(gb);
    p.popMatrix();
    p.noStroke();
  }

  public void drawRealVelocities(GraphBackground gb) {
    for (int i = 0; i < data.length; i++) {
      float mappedR = PApplet.map((float) data[i][0], 0, 8, 0, gb.graphWidth - 2 * gb.distanceFromEdge);
      float mappedV = PApplet.map((float) data[i][1], 0, 60, 0, gb.graphHeight - 2 * gb.distanceFromEdge);
      p.stroke(255, 255, 0);
      p.fill(255, 255, 0);
      p.ellipse(mappedR, -mappedV, 5, 5); // Draw a circle with a diameter of 10
      p.noStroke();
    }
  }
}
