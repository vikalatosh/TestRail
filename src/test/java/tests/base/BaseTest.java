package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import steps.LoginSteps;
import steps.ProjectSteps;
import steps.StartSteps;
import steps.TestCaseSteps;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;
    protected String email;
    protected String password;
    protected StartSteps startSteps;
    protected LoginSteps loginSteps;
    protected ProjectSteps projectSteps;
    protected TestCaseSteps testCaseSteps;

    @Step("Open browser")
    @BeforeMethod()
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        testContext.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        baseUrl = utils.PropertyReader.getProperty("TESTRAIL_URL", "testrail.baseUrl");
        email = utils.PropertyReader.getProperty("TESTRAIL_EMAIL", "testrail.email");
        password = utils.PropertyReader.getProperty("TESTRAIL_PASSWORD", "testrail.password");
        loginSteps = new LoginSteps(driver);
        projectSteps = new ProjectSteps(driver);
        startSteps = new StartSteps(driver);
        testCaseSteps = new TestCaseSteps(driver);
    }

    @Step("Close browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
