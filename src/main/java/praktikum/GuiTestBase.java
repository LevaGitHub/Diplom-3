package praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class GuiTestBase {

    protected WebDriver driver;

    @Before
    public void selectBrowser() {
        if ("yandex".equals(System.getProperty("browser")))
            setUpChrome();
        else
            setUpChrome();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    // Драйвер для Chrome
    public void setUpChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }


    @After
    public void tearDown() {
        driver.quit();
    }


}
