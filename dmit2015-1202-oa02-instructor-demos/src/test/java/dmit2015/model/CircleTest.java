package dmit2015.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void area() {
        // Create a circle with a radius of 1
        Circle circle1 = new Circle();
        // The radius should be 1
        assertEquals(1, circle1.getRadius());
        // Change the radius to 2
        circle1.setRadius(2);
        // The radius should be 2
        assertEquals(2, circle1.getRadius());
        // The area should be 12.57
        assertEquals(12.57, circle1.area(), 0.005);
    }

    @Test
    void circumference() {
        // Create a circle with a radius of 5
        Circle circle1 = new Circle(5);
        // The radius should be 5
        assertEquals(5, circle1.getRadius());
        // The circumference should be 31.42
        assertEquals(31.42, circle1.circumference(), 0.005);
    }

    @Test
    void diameter() {
        // Create a circle with a radius of 10
        Circle circle1 = new Circle(10);
        // The radius should be 10
        assertEquals(10, circle1.getRadius());
        // The diameter should be 20
        assertEquals(20, circle1.diameter(), 0);
    }
}