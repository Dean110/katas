package triangles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TriangleSorter {
    public String analyze(Integer... sides) {
        List<Integer> triangleSides = Arrays.asList(sides);
        Collections.sort(triangleSides);
        Integer sideA = triangleSides.get(0);
        Integer sideB = triangleSides.get(1);
        Integer sideC = triangleSides.get(2);
        if (isAnEquilateralTriangle(sideA, sideB, sideC)) {
            return "Equilateral";
        } else if (isARightTriangle(sideA, sideB, sideC)) {
            return "Right";
        } else {
            return "Isosceles";
        }
    }

    private boolean isAnEquilateralTriangle(int sideA, int sideB, int sideC) {
        return sideA == sideB && sideB == sideC;
    }

    private boolean isARightTriangle(int sideA, int sideB, int sideC) {
        return Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2);
    }
}
