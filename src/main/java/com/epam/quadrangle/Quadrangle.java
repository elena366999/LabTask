package com.epam.quadrangle;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Quadrangle {
    private static Point a, b, c, d;
    private static final Quadrangle instance = new Quadrangle();

    private Quadrangle() {}

    public Quadrangle(double ax, double ay, double bx, double by,double cx, double cy, double dx, double dy) {
        this.a = new Point(ax, ay);
        this.b = new Point(bx, by);
        this.c = new Point(cx, cy);
        this.d = new Point(dx, dy);
    }

    public double getPerimeter() {
        return Point.getDistance(a, b) +  Point.getDistance(b, c) +  Point.getDistance(c, d) +  Point.getDistance(d, a);
    }

    public double getArea()  {
        return Math.sqrt((getPerimeter() - Point.getDistance(a, b))* (getPerimeter() - Point.getDistance(b, c))*(getPerimeter() - Point.getDistance(c, d))*(getPerimeter() - Point.getDistance(d, a)));
    }

    boolean ArePointsOnLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x3 * (y2 - y1) - y3 * (x2 - x1) == x1 * y2 - x2 * y1);
    }

    boolean isQuadrangle(double x1, double y1, double x2, double y2,
                              double x3, double y3, double x4, double y4) {
        if (ArePointsOnLine(x2, y2, x3, y3, x4, y4) ||
                ArePointsOnLine(x1, y1, x3, y3, x4, y4) ||
                ArePointsOnLine(x1, y1, x2, y2, x4, y4) ||
                ArePointsOnLine(x1, y1, x2, y2, x3, y3)) {
            return false;
        }
        return true;
    }

        private static void getDataFromFile() throws IOException {


        File file = new File("C:\\Users\\Лена\\IdeaProjects\\LabTask\\src\\main\\java\\com\\epam\\quadrangle\\PointCoordinates.txt");
        Scanner scanner = new Scanner(file);

            }



}
