package triangles;

public class TriangleSorter {
    public String analyze(int sideA, int sideB, int sideC) {
        if (sideA == sideB && sideB == sideC) {
            return "Equilateral";
        } else {
            return "Isosceles";
        }
    }
}
