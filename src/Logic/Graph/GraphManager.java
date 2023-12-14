package Logic.Graph;

import processing.core.*;

public class GraphManager {
  PApplet p;
  GraphBackground gb;

  public GraphManager(PApplet p) {
    this.p = p;
    gb = new GraphBackground(p);
  }

  public void run() {
    gb.show();
  }

}
