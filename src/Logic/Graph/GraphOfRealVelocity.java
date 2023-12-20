package Logic.Graph;

import processing.core.*;

public class GraphOfRealVelocity {
  PApplet p;
  GraphBackground gb;

  // Define your points
  double[][] data = {
      { 0.68, 55 }, { 1.36, 92 }, { 2.04, 110 }, { 2.72, 123 }, { 3.40, 134 },
      { 4.08, 142 }, { 4.76, 145 }, { 5.44, 147 }, { 6.12, 148 }, { 6.80, 152 },
      { 7.48, 155 }, { 8.16, 156 }, { 9.52, 157 }, { 10.88, 153 }, { 12.24, 153 },
      { 13.60, 154 }, { 14.96, 153 }, { 16.32, 150 }, { 17.68, 149 }, { 19.04, 148 },
      { 20.40, 146 }, { 21.76, 147 }, { 23.12, 148 }, { 24.48, 148 }, { 25.84, 149 },
      { 27.20, 150 }, { 28.56, 150 }, { 29.92, 149 } };

  double[] uncertainties = { 35.9, 16.3, 16.1, 15.4, 7.61, 10.3, 8.09, 7.6, 3.03, 5.31, 7.51, 5.32, 5.21, 5.67, 5.39,
      4.34, 2.36, 0.89, 2.84, 0.88, 1.23, 1.57, 3.0, 3.0,
      2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0,
      2.0, 2.0, 3.0, 3.0 };

  GraphOfRealVelocity(PApplet p, GraphBackground gb) {
    this.p = p;
    this.gb = gb;
  }

  // Draw the stars
  public void draw() {
    p.pushMatrix();
    p.translate(gb.graphX + gb.distanceFromEdge, gb.graphY + gb.graphHeight - gb.distanceFromEdge);
    drawRealVelocities(gb);
    p.popMatrix();
    p.noStroke();
  }

  // Map the stars to the graph
  public void drawRealVelocities(GraphBackground gb) {
    for (int i = 0; i < data.length; i++) {
      float mappedR = PApplet.map((float) data[i][0], (float) 0, 30, 0,
          gb.graphWidth - 2 * gb.distanceFromEdge);
      float mappedV = PApplet.map((float) data[i][1], (float) 0, 250, 0,
          gb.graphHeight - 2 * gb.distanceFromEdge);
      float mappedUncertainty = PApplet.map((float) uncertainties[i], 0, (float) 250, 0,
          gb.graphHeight - 2 * gb.distanceFromEdge);
      p.stroke(255);
      p.fill(255);
      p.ellipse(mappedR, -mappedV, 5, 5); // Draw a circle with a diameter of 10
      // Draw uncertainty as a line segment
      p.line(mappedR, -mappedV + mappedUncertainty, mappedR, -mappedV - mappedUncertainty);
    }
    p.noStroke();
    p.noFill();
  }
}
