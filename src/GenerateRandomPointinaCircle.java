class Solution {
    public static void main(String[] args) {
        System.out.println(Math.toRadians(360));
    }
    double radius, x_center, y_center,rad360;
    public Solution(double radius, double x_center, double y_center) {
     this.radius=radius;
     this.x_center=x_center;
     this.y_center=y_center;
     this.rad360=Math.toRadians(360);
    }

    public double[] randPoint() {
      double rad=Math.sqrt(Math.random())*radius;
      double angle=Math.random()*rad360;
      double x=Math.cos(angle)*rad + x_center;
      double y=Math.sin(angle)*rad + y_center;
      return new double[]{x,y};
    }
}