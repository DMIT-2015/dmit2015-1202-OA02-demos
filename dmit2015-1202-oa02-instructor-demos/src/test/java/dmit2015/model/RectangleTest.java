package dmit2015.model;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void area() {
        // Create a Rectangle object with a length of 10 and width of 20
        Rectangle rectangle1 = new Rectangle(10, 20);
        // The length should be 10
        assertEquals(10, rectangle1.getLength());
        // The width should be 20
        assertEquals(20, rectangle1.getWidth());
        // The area should be 200
        assertEquals(200, rectangle1.area());
    }

    @Test
    void perimeter() {
        // Create a Rectangle object
        Rectangle rectangle1 = new Rectangle();
        // Set the length to 100
        rectangle1.setLength(100);
        // The length should be 100
        assertEquals(100, rectangle1.getLength());
        // Set the width to 300
        rectangle1.setWidth(300);
        // The width should be 300
        assertEquals(300, rectangle1.getWidth());
        // The perimeter should 800
        assertEquals(800, rectangle1.perimeter());
    }

    @Test
    void shouldCreateImageFile() throws IOException {
        // Create a Rectangle of 640 by 480
        Rectangle rectangle1 = new Rectangle(640,480);
        // Create an image file with an Rectangle drawn on it
        File imageFile = rectangle1.createImageFile("/home/user2015/Pictures/rectangle.png");
        // The imageFile should not be null
        assertNotNull(imageFile);
    }
}