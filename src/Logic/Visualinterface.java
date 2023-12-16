package Logic;

import processing.core.*;

public class Visualinterface {
  PApplet p;

  boolean pressed1;
  boolean pressed2;
  boolean pressed3;
  boolean pressed4;

  public Visualinterface(PApplet p) {
    this.p = p;

    pressed1 = true;
  }

  public void show() {
    // First box
    p.stroke(255);
    p.strokeWeight(2);
    p.rect(p.width / 2 + 30, 20, 40, 40);
    p.fill(255);
    p.textSize(20);
    p.text("Use newtonian gravity: ", p.width / 2 - 170, 45);
    p.noFill();

    // Second box
    p.rect(p.width / 2 + 218, 20, 40, 40);
    p.fill(255);
    p.textSize(20);
    p.text("Use visible disk: ", p.width / 2 + 80, 45);
    p.noFill();

    // Third box
    p.rect(p.width / 2 + 418, 20, 40, 40);
    p.fill(255);
    p.textSize(20);
    p.text("Use dark matter: ", p.width / 2 + 270, 45);
    p.noFill();

    p.noFill();
    // Fourth box
    p.rect(p.width - 60, 20, 40, 40);
    p.fill(255);
    p.textSize(20);
    p.text("Use dark matter and visible disk:", p.width / 2 + 465, 45);
    p.noFill();
    p.noStroke();

    // Draw check mark if pressed1 is true
    if (pressed1) {
      p.stroke(0, 255, 0);
      p.strokeWeight(2);
      p.line(p.width / 2 + 35, 35, p.width / 2 + 45, 55);
      p.line(p.width / 2 + 45, 55, p.width / 2 + 65, 25);
      p.noStroke();
    }

    // Draw check mark if pressed2 is true
    if (pressed2) {
      p.stroke(0, 255, 0);
      p.strokeWeight(2);
      p.line(p.width / 2 + 223, 35, p.width / 2 + 237, 55);
      p.line(p.width / 2 + 237, 55, p.width / 2 + 257, 25);
      p.noStroke();
    }

    // Draw check mark if pressed3 is true
    if (pressed3) {
      p.stroke(0, 255, 0);
      p.strokeWeight(2);
      p.line(p.width / 2 + 423, 35, p.width / 2 + 437, 55);
      p.line(p.width / 2 + 437, 55, p.width / 2 + 457, 25);
      p.noStroke();
    }

    // Draw check mark if pressed4 is true
    if (pressed4) {
      p.stroke(0, 255, 0);
      p.strokeWeight(2);
      p.line(p.width - 55, 35, p.width - 45, 55);
      p.line(p.width - 45, 55, p.width - 25, 25);
      p.noStroke();
    }

    if (p.frameCount % 5 == 0) {
      // Check if mouse is inside the first box
      if (p.mousePressed && p.mouseX > p.width / 2 + 30 && p.mouseX < p.width / 2 + 70
          && p.mouseY > 20 && p.mouseY < 60) {
        pressed1 = true;
        pressed2 = false;
        pressed3 = false;
        pressed4 = false;
      }

      // Check if mouse is inside the second box
      if (p.mousePressed && p.mouseX > p.width / 2 + 218
          && p.mouseX < p.width / 2 + 258
          && p.mouseY > 20 && p.mouseY < 60) {
        pressed1 = false;
        pressed2 = true;
        pressed3 = false;
        pressed4 = false;
      }

      // Check if mouse is inside the third box
      if (p.mousePressed && p.mouseX > p.width / 2 + 418
          && p.mouseX < p.width / 2 + 458
          && p.mouseY > 20 && p.mouseY < 60) {
        pressed1 = false;
        pressed2 = false;
        pressed3 = true;
        pressed4 = false;
      }

      // Check if mouse is inside the fourth box
      if (p.mousePressed && p.mouseX > p.width - 60 && p.mouseX < p.width - 20
          && p.mouseY > 20 && p.mouseY < 60) {
        pressed1 = false;
        pressed2 = false;
        pressed3 = false;
        pressed4 = true;
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