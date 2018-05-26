package com.training.epam;

import com.training.epam.bin.Point;
import com.training.epam.bin.Quadrangle;
import com.training.epam.exception.CustomException;
import com.training.epam.util.QuadrangleFactory;
import com.training.epam.util.QuadrangleUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, CustomException {

        QuadrangleFactory factory = new QuadrangleFactory();
        File file = new File("C:\\Users\\Лена\\IdeaProjects\\LabTask\\src\\main\\java\\com\\training\\epam\\inputData\\validData.txt");
        Quadrangle q = factory.createQuadrangle(file);
        QuadrangleUtil qu = new QuadrangleUtil();
        System.out.println(qu.getPerimeter(q));
        System.out.println(qu.getArea(q));

    }
}
