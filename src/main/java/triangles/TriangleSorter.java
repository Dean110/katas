package triangles;

public class TriangleSorter {
    public String analyze(int sideA, int sideB, int sideC) {
        if (isAnEquilateral(sideA, sideB, sideC)) {
            return "Equilateral";
        } else {
            return "Isosceles";
        }
    }

    private boolean isAnEquilateral(int sideA, int sideB, int sideC) {
        return sideA == sideB && sideB == sideC;
    }
}
