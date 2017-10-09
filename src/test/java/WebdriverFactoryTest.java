import com.webdriver.concrete.WebDriverType;
import com.webdriver.contracts.WebDriverFactory;
import com.webdriver.contracts.WebDriverWrapper;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class WebdriverFactoryTest {

    @Test
    public void startDriverAndNavigate() {
        WebDriverWrapper wrapper = WebDriverFactory.getDriver(WebDriverType.CHROME);
        WebDriver driver = wrapper.getDriver();

        driver.get("http://google.com");
        Google google = PageFactory.initElements(driver, Google.class);
        assertTrue("Search Bar is missing", google.isSearchBarExists());
        wrapper.closeDriver();

    }

}
