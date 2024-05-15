import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.Browser;

public class ScannerTest {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new Browser().chromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void scanForIssues() {
        AI ai = new AI();
        ai.setOpenAPIKey("sk-proj-");
        ai.setOpenAPIProject("proj_");
        ai.setOpenAIOrgId("org-");

        driver.get("http://www.itsecgames.com/download.htm");
        String response = ai.scan(driver.getPageSource());
        System.out.println(response);
    }
}