package triangles;

public class TriangleSorter {
    public String analyze(int sideA, int sideB, int sideC) {
        if (isAnEquilateral(sideA, sideB, sideC)) {
            return "Equilateral";
        } else if (Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2)) {
            return "Right";
        } else {
            return "Isosceles";
        }
    }

    private boolean isAnEquilateral(int sideA, int sideB, int sideC) {
        return sideA == sideB && sideB == sideC;
    }
}
