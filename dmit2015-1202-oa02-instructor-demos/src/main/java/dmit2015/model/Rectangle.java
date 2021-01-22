package dmit2015.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class models a Rectangle shape.
 *
 * @author  Sam Wu
 * @version 2021.01.15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle {

    private double length;

    private double width;

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new RuntimeException("Length must be greater than zero.");
        }
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new RuntimeException("Width must be greater than zero.");
        }
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    public File createImageFile(String imageFilePath) throws IOException {
        final int imageWidth = (int) width;
        final int imageHeight = (int) length;

        BufferedImage rectangleImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rectangleImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0,0, imageWidth, imageHeight);
        g2d.setStroke( new BasicStroke(10.0f) );
        g2d.setColor(Color.green);
        g2d.draw(new Rectangle2D.Double(0,0, imageWidth, imageHeight));
        g2d.dispose();

        File imageFile = new File(imageFilePath);
        ImageIO.write(rectangleImage, "png", imageFile);

        return imageFile;
    }
}
