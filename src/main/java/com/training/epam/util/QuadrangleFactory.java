package com.training.epam.util;

import com.training.epam.bin.Point;
import com.training.epam.bin.Quadrangle;
import com.training.epam.exception.CustomException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuadrangleFactory {
    /**
     * Method for creating a Circle object.
     * @param file path
     * @return circle obj
     * @throws IOException
     * @throws CustomException
     */
    public Quadrangle createQuadrangle(File file) throws IOException, CustomException {
        int[] values = QuadrangleUtil.readDataFromFile(file);
        List<Point> points2 = new ArrayList<Point>();

        for (int i = 0; i < values.length; i++) {
            if(i%2==0){
                Point p = new Point(values[i], values[i+1]);
                points2.add(p);
            }
        }

        return new Quadrangle(points2);

    }

}
