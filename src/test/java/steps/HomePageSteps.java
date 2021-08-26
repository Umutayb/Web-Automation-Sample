package steps;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.driver.Driver;

public class HomePageSteps extends Driver {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @Step("Click category card named <cardName>")
    public void clickCategoryCard(String cardName) {
        homePage.clickCategoryCardNamed(cardName);
    }
}
