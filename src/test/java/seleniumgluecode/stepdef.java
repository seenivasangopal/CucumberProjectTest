package seleniumgluecode;


import com.opencsv.CSVReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;
import java.io.FileReader;
import java.net.URL;
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
//        driver = new ChromeDriver();
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL("http://192.168.1.7:4444"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.capgemini.com/");
        System.out.println("testing message");
        String path=new File("src/test/resources/csvfiles/excsvfile.csv").getAbsolutePath();
        System.out.println("path--->"+path);
        readDataLineByLine(path);
//        readDataLineByLine("C:/Users/gseeniva/OneDrive - Capgemini/Documents/intellij/demo/Cucumber_testing/src/test/resources/csvfiles/excsvfile.csv");
//        readDataLineByLine("http://localhost:1111/job/CucumberTestingWithGit/ws/src/test/resources/csvfiles/excsvfile.csv");

    }
    public static void readDataLineByLine(String file)
    {

        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^enter cucumber and hit the serch button$")
    public void enter_cucumber_and_hit_the_serch_button() throws Throwable {
        driver.quit();
    }
}
