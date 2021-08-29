package steps;

import com.thoughtworks.gauge.Step;
import utils.Utilities;

public class CommonSteps {

    Utilities utils = new Utilities();

    @Step("Navigate to <url>")
    public void getUrl(String url) {utils.navigate(url);}

    @Step("Refresh the page")
    public void refresh() {
        utils.refreshThePage();
    }

    @Step("Navigate browser <direction>")
    public void browserNavigate(String direction) {
        utils.navigateBrowser(direction);
    }

    @Step("Wait <duration> seconds")
    public void wait(Integer duration) {
        utils.waitFor(duration);
    }

}