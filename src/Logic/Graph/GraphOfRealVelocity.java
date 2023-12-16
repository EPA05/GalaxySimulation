package Logic.Graph;

import org.apache.commons.math3.fitting.WeightedObservedPoints;
import processing.core.*;

public class GraphOfRealVelocity {
  PApplet p;
  GraphBackground gb;
  private boolean graphCalculated = false;
  private PShape graphShape;

  // Define your points
  double[][] data = {
      { 0.68, 55 }, { 1.36, 92 }, { 2.04, 110 }, { 2.72, 123 }, { 3.40, 134 },
      { 4.08, 142 }, { 4.76, 145 }, { 5.44, 147 }, { 6.12, 148 }, { 6.80, 152 },
      { 7.48, 155 }, { 8.16, 156 }, { 9.52, 157 }, { 10.88, 153 }, { 12.24, 153 },
      { 13.60, 154 }, { 14.96, 153 }, { 16.32, 150 }, { 17.68, 149 }, { 19.04, 148 },
      { 20.40, 146 }, { 21.76, 147 }, { 23.12, 148 }, { 24.48, 148 }, { 25.84, 149 },
      { 27.20, 150 }, { 28.56, 150 }, { 29.92, 149 } };

  GraphOfRealVelocity(PApplet p, GraphBackground gb) {
    this.p = p;
    this.gb = gb;
  }

  public void draw() {
    drawRealVelocities(gb);
  }

  public void drawGraph(GraphBackground gb) {
    p.stroke(0, 255, 0); // Set stroke color to magenta
    p.noFill();

    WeightedObservedPoints points = new WeightedObservedPoints();

    for (double[] point : data) {
      points.add(point[0], point[1]);
    }
    graphCalculated = true;
    if (!graphCalculated) {
      graphShape = p.createShape();
      graphShape.beginShape();
      for (int i = 0; i < data.length; i++) {
        float x = PApplet.map((float) data[i][0], (float) 0.68, 30, 0, gb.graphWidth - 2 * gb.distanceFromEdge);
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
    p.pushMatrix();
    p.translate(gb.graphX + gb.distanceFromEdge, gb.graphY + gb.graphHeight - gb.distanceFromEdge);

    for (int i = 0; i < data.length; i++) {
      float mappedR = PApplet.map((float) data[i][0], 0, 30, 0, gb.graphWidth - 2 * gb.distanceFromEdge);
      float mappedV = PApplet.map((float) data[i][1], 0, 250, 0, gb.graphHeight - 2 * gb.distanceFromEdge);
      p.stroke(255, 255, 0);
      p.fill(255, 255, 0);
      p.ellipse(mappedR, -mappedV, 5, 5); // Draw a circle with a diameter of 10
      p.noStroke();
    }

    p.popMatrix();
    p.noStroke();
  }
}
