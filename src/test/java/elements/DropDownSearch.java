package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class DropDownSearch extends BaseElement {
    WebDriver driver;
    String label;
    String locator = "//*[contains(text(),'%s')]//following-sibling::div";
    String optionLocator = "//li[contains(text(),'%s')]";

    public DropDownSearch(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        log.debug("Writing text {} into input with label {}", option, label);
        WebElement element = driver.findElement(By.xpath(String.format(locator, label)));
        highlightElement(driver, element);
        element.click();
        element = driver.findElement(By.xpath(String.format(optionLocator, option)));
        highlightElement(driver, element);
        element.click();
    }
}
