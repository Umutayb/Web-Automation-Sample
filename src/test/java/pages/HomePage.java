package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Actions;
import java.util.List;
import static java.awt.Color.*;

public class HomePage {

    Actions actions = new Actions();

    @FindBy(css = "[class='card mt-4 top-card']")
    public List<WebElement> categoryCards;

    public void clickCategoryCardNamed(String cardName){
        for (WebElement card:categoryCards) {
            if (card.getText().contains(cardName)){
                actions.clickElement(card);
                return;
            }
        }
        Assert.fail(RED+"No category card named "+cardName+" could be found in HomePage @clickCategoryCard");
    }
}
