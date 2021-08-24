import com.thoughtworks.gauge.*;
import utils.PropertiesReader;
import utils.StringUtilities;
import utils.driver.Driver;

public class Initialize extends Driver {

    PropertiesReader reader = new PropertiesReader("properties-from-pom.properties");

    StringUtilities strUtils = new StringUtilities();

    @BeforeSpec
    public void init(){
        String browser = reader.getProperty("browser");
        setup(strUtils.firstLetterCapped(browser));
    }

    @AfterSpec
    public void terminate(){
        teardown();
    }
}
