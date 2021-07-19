package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Input {
    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.debug(String.format("Writing text '%s' into input with label %s", text, label));
        WebElement element = driver.findElement(By.id(label.toLowerCase()));
        highlightElement(driver, element);
        element.sendKeys(text);
    }

    public void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: #3cff3c; border: 2px solid red;');", element);
    }
}
