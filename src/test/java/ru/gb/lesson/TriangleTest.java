package ru.gb.lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Треугольник")
public class TriangleTest{
    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6),
                Arguments.of(new Triangle(10, 10, 16), 48),
                Arguments.of(new Triangle(60, 60, 60), 1558.8457268119896)
        );
    }

    @ParameterizedTest(name = "Площадь треугольника {0} равна {1}")
    @MethodSource("triangles")
    public void GetAreaTest(Triangle triangle, double expectedArea) {
        double area = triangle.GetArea(); //Act
        assertEquals(expectedArea, area); //Assert
    }
}