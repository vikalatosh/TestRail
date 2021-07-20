package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Input extends BaseElement {
    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.debug("Writing text {} into input with label {}", text, label);
        WebElement element = driver.findElement(By.id(label.toLowerCase()));
        highlightElement(driver, element);
        element.sendKeys(text);
    }
}
