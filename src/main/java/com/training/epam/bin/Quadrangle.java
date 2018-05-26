package com.training.epam.bin;

import com.training.epam.util.QuadrangleUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Quadrangle {
    private List<Point> points;
    private static final Quadrangle instance = new Quadrangle();

    private Quadrangle() {}

    public Quadrangle(List<Point> points) {
    this.points = points;
    }

    public  List<Point> getPoints() {
        return points;
    }

    public  void setPoints(List<Point> points) {
        this.points = points;
    }


    boolean ArePointsOnLine(List<Point> points) {
        return (points.get(2).getX() * (points.get(1).getY() - points.get(0).getY()) - points.get(2).getY() * (points.get(1).getX() - points.get(0).getX()) == points.get(0).getX() * points.get(1).getY() - points.get(1).getX() * points.get(0).getY());
    }

    boolean isQuadrangle(List<Point> points) {
        List<Point> temp1= new ArrayList<Point>();
        List<Point> temp2= new ArrayList<Point>();
        List<Point> temp3= new ArrayList<Point>();
        temp1.add(points.get(1));
        temp1.add(points.get(2));
        temp1.add(points.get(3));
        temp2.add(points.get(2));
        temp2.add(points.get(3));
        temp2.add(points.get(0));
        temp3.add(points.get(3));
        temp3.add(points.get(0));
        temp3.add(points.get(1));
        if (ArePointsOnLine(points.subList(0,3)) ||
                ArePointsOnLine(temp1) ||
                ArePointsOnLine(temp2) ||
                ArePointsOnLine(temp3) ){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "points=" + points +
                '}';
    }
}
