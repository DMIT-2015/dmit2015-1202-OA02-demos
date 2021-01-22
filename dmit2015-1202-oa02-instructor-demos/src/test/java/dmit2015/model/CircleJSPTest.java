package dmit2015.model;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@ExtendWith(SeleniumJupiter.class)
public class CircleJSPTest {

    @Test
    void testWithFireFox(FirefoxDriver driver) {
        driver.get("http://localhost:8080/dmit2015-1202-oa02-instructor-demos/circle.jsp");
        Assertions.assertEquals("Circle Calculator", driver.getTitle());
        WebElement radiusElement = driver.findElement(By.id("radius"));
        radiusElement.clear();
        radiusElement.sendKeys("5");
        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();
        WebElement areaElement = driver.findElement(By.id("area"));
        Assertions.assertEquals("Area = 78.53981633974483", areaElement.getText());

    }
}
