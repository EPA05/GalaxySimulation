package Logic.Graph;

import processing.core.*;

public class GraphBackground {
  PApplet p;
  int graphWidth;
  int graphHeight;
  int graphX;
  int graphY;
  int distanceFromEdge;
  int borderWidth;

  GraphBackground(PApplet p) {
    this.p = p;
    graphWidth = 600;
    graphHeight = 400;
    graphX = 20;
    graphY = 20;
    distanceFromEdge = 80;
    borderWidth = 2;
  }

  public void show() {
    // Draw the graph background
    p.fill(0, 200);
    p.rect(graphX, graphY, graphWidth, graphHeight);

    // Draw the graph border
    p.stroke(255);
    p.strokeWeight(borderWidth);
    p.noFill();
    p.rect(graphX, graphY, graphWidth, graphHeight);

    // Draw the x-axis
    p.stroke(255, 0, 0); // Set stroke color to red
    p.line(graphX + distanceFromEdge, graphY + graphHeight - distanceFromEdge,
        graphX + graphWidth - distanceFromEdge,
        graphY + graphHeight - distanceFromEdge);
    p.fill(255);
    p.textSize(20);
    p.text("Distance [AU]", graphWidth / 2 - 30, graphY + graphHeight - 30);

    // Draw the y-axis
    p.stroke(0, 0, 255); // Set stroke color to blue
    p.line(graphX + distanceFromEdge, graphY + distanceFromEdge, graphX + distanceFromEdge,
        graphY + graphHeight - distanceFromEdge);
    p.fill(255);
    p.pushMatrix(); // Save the current transformation matrix
    p.translate(graphX + 20, graphY + graphHeight / 2 + 70); // Translate to the text position
    p.rotate(-PApplet.HALF_PI); // Rotate the text by -90 degrees
    p.text("Velocity [km/s]", 0, 0); // Draw the rotated text
    p.popMatrix(); // Restore the previous transformation matrix

    // Draw the vertical lines on the x-axis
    p.textSize(15);
    p.stroke(0, 255, 0);
    int numVerticalLines = 11;
    float verticalLineSpacing = (float) (graphWidth - 2 * distanceFromEdge) / (numVerticalLines - 1);
    for (int i = 0; i < numVerticalLines; i++) {
      float x = graphX + distanceFromEdge + i * verticalLineSpacing;
      p.line(x, graphY + graphHeight - distanceFromEdge, x, graphY + graphHeight - distanceFromEdge + 5);
      p.text((i * 3) + " kpc", x - 10, graphY + graphHeight - distanceFromEdge + 20); // Add text at each line
    }

    // Draw the horizontal lines on the y-axis
    p.textSize(15);
    p.stroke(255, 255, 0);
    int numHorizontalLines = 6;
    float horizontalLineSpacing = (float) (graphHeight - 2 * distanceFromEdge) / (numHorizontalLines - 1);
    for (int i = 0; i < numHorizontalLines; i++) {
      float y = graphY + graphHeight - distanceFromEdge - i * horizontalLineSpacing;
      p.line(graphX + distanceFromEdge, y, graphX + distanceFromEdge - 5, y);
      p.text((i * 50) + " km/s", graphX + distanceFromEdge - 55, y + 5); // Add text at each line
    }
    p.noStroke();
  }
}
