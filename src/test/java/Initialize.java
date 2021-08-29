import com.thoughtworks.gauge.*;
import utils.Utilities;
import utils.PropertiesReader;
import utils.StringUtilities;
import utils.driver.Driver;

public class Initialize {

    PropertiesReader reader = new PropertiesReader("properties-from-pom.properties");
    StringUtilities strUtils = new StringUtilities();
    Utilities utils = new Utilities();
    Driver driver = new Driver();

    @BeforeSpec
    public void init(){
        String browser = reader.getProperty("browser");
        driver.setup(strUtils.firstLetterCapped(browser));
    }

    @AfterSpec
    public void terminate(ExecutionContext context){
        if (context.getCurrentSpecification().getIsFailing())
            utils.captureScreen(context.getCurrentSpecification().getName());
        driver.teardown();
    }
}
