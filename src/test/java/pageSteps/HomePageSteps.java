package pageSteps;

import com.thoughtworks.gauge.Step;
import static utils.driver.Driver.driver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @Step("Click category card named <cardName>")
    public void clickCategoryCard(String cardName){homePage.clickCategoryCard(cardName);}
}
