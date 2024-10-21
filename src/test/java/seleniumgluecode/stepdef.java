package seleniumgluecode;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class stepdef {
    WebDriver driver;

    @Given("^launch the google$")
    public void launchTheGoogle() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:/Users/gseeniva/OneDrive - Capgemini/Documents/intellij/demo/Cucumber_testing/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        System.out.println("testing message");
    }
    @Given("^launch the capgemini")
    public void launchTheCapgemini() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:/Users/gseeniva/OneDrive - Capgemini/Documents/intellij/demo/Cucumber_testing/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.capgemini.com/");
        System.out.println("testing message");
    }

    @When("^enter cucumber and hit the serch button$")
    public void enter_cucumber_and_hit_the_serch_button() throws Throwable {
        driver.quit();
    }
}
