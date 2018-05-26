package com.training.epam.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.training.epam.bin.Point;
import com.training.epam.bin.Quadrangle;
import com.training.epam.exception.CustomException;


public class QuadrangleUtil {
   // private static final Logger logger = LogManager.getLogger(QuadrangleUtils.class.getName());


    public static double getDistance (Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public static double getPerimeter(Quadrangle q) {
        return QuadrangleUtil.getDistance(q.getPoints().get(0), q.getPoints().get(1)) +  QuadrangleUtil.getDistance(q.getPoints().get(1), q.getPoints().get(2)) +  QuadrangleUtil.getDistance(q.getPoints().get(2), q.getPoints().get(3)) +  QuadrangleUtil.getDistance(q.getPoints().get(3), q.getPoints().get(0));
    }

    public static double getHalfPerimeter(Quadrangle q) {
        return QuadrangleUtil.getPerimeter(q)/2;
    }

    public static double getArea(Quadrangle q)  {
        return Math.sqrt((QuadrangleUtil.getHalfPerimeter(q) - QuadrangleUtil.getDistance(q.getPoints().get(0), q.getPoints().get(1)))* (QuadrangleUtil.getHalfPerimeter(q) - QuadrangleUtil.getDistance(q.getPoints().get(1), q.getPoints().get(2)))*(QuadrangleUtil.getHalfPerimeter(q) - QuadrangleUtil.getDistance(q.getPoints().get(2), q.getPoints().get(3)))*(QuadrangleUtil.getHalfPerimeter(q) - QuadrangleUtil.getDistance(q.getPoints().get(3), q.getPoints().get(0))));
    }

    boolean ArePointsOnLine(List<Point> points) {
        return (points.get(2).getX() * (points.get(1).getY() - points.get(0).getY()) - points.get(2).getY() * (points.get(1).getX() - points.get(0).getX()) == points.get(0).getX() * points.get(1).getY() - points.get(1).getX() * points.get(0).getY());
    }

       public static int[] readDataFromFile(File file) throws IOException, CustomException {
        int[] values = new int[8];
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String temp = scanner.next();
            if (temp.matches("points:")) {
                for (int i = 0; i < 8; i++) {
                    temp = scanner.next();
                    if (temp.matches("-?[0-9]+")) {
                        values[i] = Integer.valueOf(temp);
                    } else {
                        throw new CustomException("Invalid data");
                    }
                }
                break;
            }
        }

        return values;
    }

}
