package steps;

import com.thoughtworks.gauge.Step;
import utils.Actions;

public class CommonSteps {

    Actions actions = new Actions();

    @Step("Navigate to <url>")
    public void getUrl(String url) {
        actions.navigate(url);
    }

    @Step("Refresh the page")
    public void refresh() {
        actions.refreshThePage();
    }

    @Step("Navigate browser <direction>")
    public void browserNavigate(String direction) {
        actions.navigateBrowser(direction);
    }

    @Step("Wait <duration> seconds")
    public void wait(Integer duration) {
        actions.waitFor(duration);
    }

}
