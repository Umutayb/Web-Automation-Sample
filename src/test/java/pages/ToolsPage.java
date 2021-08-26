package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Actions;

import java.util.List;

import static java.awt.Color.RED;

public class ToolsPage {

    Actions actions = new Actions();

    @FindBy(css = "[class='accordion'] [class='element-group']")
    public List<WebElement> toolTypes;

    @FindBy(css = "[class='menu-list'] [id*='item']")
    public List<WebElement> tools;

    @FindBy(css = "button[id='submit']")
    public WebElement submitButton;

    @FindBy(css = "[id='userName']")
    public WebElement nameInput;

    @FindBy(css = "[id='userEmail']")
    public WebElement emailInput;

    @FindBy(css = "[id='currentAddress']")
    public WebElement currentAddressInput;

    @FindBy(css = "[id='permanentAddress']")
    public WebElement permanentAddressInput;

    public void clickSubmit(){actions.clickElement(submitButton);}

    public void fillNameInput(String text){actions.clearFillInput(nameInput, text);}

    public void fillEmailInput(String text){actions.clearFillInput(emailInput, text);}

    public void fillCurrentAddressInput(String text){actions.clearFillInput(currentAddressInput, text);}

    public void fillPermanentAddressInput(String text){actions.clearFillInput(permanentAddressInput, text);}

    public void selectToolTypeNamed(String cardName){
        for (WebElement card:toolTypes) {
            if (card.getText().contains(cardName)){
                actions.clickElement(card);
                return;
            }
        }
        Assert.fail(RED+"No tool type named "+cardName+" could be found in ToolsPage @selectToolTypeNamed");
    }

    public void selectToolNamed(String cardName){
        for (WebElement card:tools) {
            if (card.getText().contains(cardName)){
                actions.clickElement(card);
                return;
            }
        }
        Assert.fail(RED+"No tool type named "+cardName+" could be found in ToolsPage @selectToolTypeNamed");
    }
}
