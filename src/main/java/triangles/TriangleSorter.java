package triangles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TriangleSorter {
    public String analyze(Integer... sides) {
        List<Integer> sortedSides = sortSides(sides);

        return determineTriangleType(sortedSides.get(0), sortedSides.get(1), sortedSides.get(2));
    }

    private String determineTriangleType(Integer sideA, Integer sideB, Integer sideC) {
        if (isNotATriangle(sideA, sideB, sideC)) {
            return "Not A Triangle";
        }
        if (isAnEquilateralTriangle(sideA, sideB, sideC)) {
            return "Equilateral";
        }
        if (isARightTriangle(sideA, sideB, sideC)) {
            return "Right";
        }
        if (isAnIsocelesTriangle(sideA, sideB, sideC)) {
            return "Isosceles";
        }
        return "Other";
    }

    private List<Integer> sortSides(Integer[] sides) {
        List<Integer> triangleSides = Arrays.asList(sides);
        Collections.sort(triangleSides);
        return triangleSides;
    }

    private boolean isNotATriangle(int sideA, int sideB, int sideC) {
        return sideA + sideB <= sideC;
    }

    private boolean isAnEquilateralTriangle(int sideA, int sideB, int sideC) {
        return sideA == sideB && sideB == sideC;
    }

    private boolean isARightTriangle(int sideA, int sideB, int sideC) {
        return Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2);
    }

    private boolean isAnIsocelesTriangle(int sideA, int sideB, int sideC) {
        return sideA == sideB || sideB == sideC;
    }
}
