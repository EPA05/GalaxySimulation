package Logic.Graph;

import processing.core.*;

public class GraphInformation {
  PApplet p;
  boolean pressed1; // if the first box is pressed
  boolean pressed2; // if the second box is pressed
  boolean pressed3; // if the third box is pressed
  boolean pressed4; // if the fourth box is pressed

  GraphInformation(PApplet p) {
    this.p = p;

    pressed1 = false;
    pressed2 = false;
    pressed3 = false;
    pressed4 = false;
  }

  public void show() {
    // First box
    p.noFill();
    p.stroke(255);
    p.strokeWeight(2);
    p.rect(175, 30, 30, 30);
    p.fill(125, 125, 125);
    p.textSize(20);
    p.text("Show Newtonian: ", 22, 50);
    p.noFill();

    // Second box
    p.rect(375, 30, 30, 30);
    p.fill(7, 239, 255);
    p.textSize(20);
    p.text("Show visible disk: ", 220, 50);
    p.noFill();

    // Third box
    p.rect(575, 30, 30, 30);
    p.fill(255, 0, 255);
    p.textSize(20);
    p.text("Show dark matter: ", 410, 50);
    p.noFill();

    p.noFill();
    // Fourth box
    p.rect(420, 60, 30, 30);
    p.fill(21, 96, 189);
    p.textSize(20);
    p.text("Show dark matter and visible disk: ", 120, 80);
    p.noFill();
    p.noStroke();

    p.stroke(0, 255, 0);
    if (pressed1) {
      p.strokeWeight(2);
      p.line(180, 45, 190, 55);
      p.line(190, 55, 205, 30);
    }

    if (pressed2) {
      p.strokeWeight(2);
      p.line(380, 45, 390, 55);
      p.line(390, 55, 405, 30);
    }
    if (pressed3) {
      p.strokeWeight(2);
      p.line(580, 45, 590, 55);
      p.line(590, 55, 605, 30);
    }

    if (pressed4) {
      p.strokeWeight(2);
      p.line(425, 75, 435, 85);
      p.line(435, 85, 450, 60);
    }
    p.noStroke();

    // Check if the mouse is pressed and if it is, check if it is in the box
    if (p.frameCount % 5 == 0) {
      if (p.mousePressed && p.mouseX > 175 && p.mouseX < 205 && p.mouseY > 30 && p.mouseY < 60) {
        pressed1 = !pressed1;
      }

      if (p.mousePressed && p.mouseX > 375 && p.mouseX < 405 && p.mouseY > 30 && p.mouseY < 60) {
        pressed2 = !pressed2;
      }

      if (p.mousePressed && p.mouseX > 575 && p.mouseX < 605 && p.mouseY > 30 && p.mouseY < 60) {
        pressed3 = !pressed3;
      }

      if (p.mousePressed && p.mouseX > 420 && p.mouseX < 450 && p.mouseY > 60 && p.mouseY < 90) {
        pressed4 = !pressed4;
      }
    }
  }

  public boolean GetIsPressed1() {
    return pressed1;
  }

  public boolean GetIsPressed2() {
    return pressed2;
  }

  public boolean GetIsPressed3() {
    return pressed3;
  }

  public boolean GetIsPressed4() {
    return pressed4;

  }
}
