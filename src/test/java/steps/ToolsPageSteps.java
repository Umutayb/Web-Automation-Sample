package steps;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.PageFactory;
import pages.ToolsPage;
import utils.driver.Driver;

public class ToolsPageSteps extends Driver {

    ToolsPage toolsPage = PageFactory.initElements(driver, ToolsPage.class);

    @Step("Click tool named <toolName>")
    public void clickToolNamed(String toolName) {toolsPage.selectToolNamed(toolName);}

    @Step("Click tool type named <toolType>")
    public void clickToolTypeNamed(String toolName) {toolsPage.selectToolTypeNamed(toolName);}

    @Step("Fill name input with <name>")
    public void fillNameInput(String name) {toolsPage.fillNameInput(name);}

    @Step("Fill email input with <email>")
    public void fillEmailInput(String email) {toolsPage.fillEmailInput(email);}

    @Step("Fill current address input with <address>")
    public void fillCurrentAddressInput(String currentAddress) {toolsPage.fillCurrentAddressInput(currentAddress);}

    @Step("Fill permanent address input with <address>")
    public void fillPermanentAddressInput(String permanentAddress) {toolsPage.fillPermanentAddressInput(permanentAddress);}

    @Step("Click submit button")
    public void clickSubmit() {toolsPage.clickSubmit();}
}
