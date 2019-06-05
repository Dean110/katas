package triangles;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrianglesTest {
    private TriangleSorter underTest;

    private void assertTriangleType(int sideA, int sideB, int sideC, String assertedTriangleType) {
        String triangleType = underTest.analyze(sideA, sideB, sideC);
        assertThat(triangleType, is(assertedTriangleType));
    }

    @Before
    public void setup() {
        underTest = new TriangleSorter();
    }

    @Test
    public void threeEqualSidesIsAnEquilateralTriangle() {
        assertTriangleType(3, 3, 3, "Equilateral");
    }

    @Test
    public void twoEqualSidesAndAnUnequalSideIsAnIsoscelesTriangle() {
        assertTriangleType(3, 3, 2, "Isosceles");
    }

    @Test
    public void twoSidesWhoseSquaresEqualTheSqareOfTheRemainingSideIsARightTriangle() {
        assertTriangleType(3, 4, 5, "Right");
    }
    @Test
    public void passingSidesInADifferentOrderReturnsTheSameResult() {
        assertTriangleType(3, 3, 2, "Isosceles");
        assertTriangleType(3, 2, 3, "Isosceles");
        assertTriangleType(2, 3, 3, "Isosceles");
    }
}
