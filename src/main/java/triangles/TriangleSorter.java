package triangles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TriangleSorter {
    public String analyze(Integer... sides) {
        List<Integer> triangleSides = sortSides(sides);

        return determineTriangleType(triangleSides.get(0), triangleSides.get(1), triangleSides.get(2));
    }

    private String determineTriangleType(Integer sideA, Integer sideB, Integer sideC) {
        if (isAnEquilateralTriangle(sideA, sideB, sideC)) {
            return "Equilateral";
        } else if (isARightTriangle(sideA, sideB, sideC)) {
            return "Right";
        } else {
            return "Isosceles";
        }
    }

    private List<Integer> sortSides(Integer[] sides) {
        List<Integer> triangleSides = Arrays.asList(sides);
        Collections.sort(triangleSides);
        return triangleSides;
    }

    private boolean isAnEquilateralTriangle(int sideA, int sideB, int sideC) {
        return sideA == sideB && sideB == sideC;
    }

    private boolean isARightTriangle(int sideA, int sideB, int sideC) {
        return Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2);
    }
}
