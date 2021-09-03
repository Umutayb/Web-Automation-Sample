#Quickstart Library
###For POM & Gauge Projects
___
###How To Get Started:

First, the library should be exported into an empty automation project by using:
```
mvn clean package -DbuildDirectory=directory/to/project/lib
```
For instance:
```
mvn clean package -DbuildDirectory=/Users/Umut/Github/Web-Automation-Sample-Cucumber/lib
```
There, the imported jar file should be added as a dependency in pom.xml file of that project:
```
<!-- Framework -->
        <dependency>
            <groupId>bora</groupId>
            <artifactId>POM-Framework-0.0.2.jar</artifactId>
            <version>0.0.2</version>
            <systemPath>${project.basedir}/lib/POM-FRAMEWORK-0.0.2.jar</systemPath>
            <scope>system</scope>
            <type>jar</type>
        </dependency>
```
After updating your project, the quickstart library is ready to use.
___
###How To Use:

The quickstart library consists of many utility methods and a ready to use built in selenium grid infrastructure,
compatible with page object model design. The infrastructure allows easy initialization of elements by initializing them
within a constructor inside the **Utilities** class. In order to initialize elements inside a page class, all it takes is
to extend the **Utilities** class. This also extends the **Driver** class, allowing usage of driver inside page classes.

####Step 1: Create a pages package
>Create page classes, add elements (use @FindBy annotation) & page methods. _**Remember** extending **Utilities** class,
> initializing all elements within the page class._
>````
> public class HomePage extends Utilities {...}
>```` 

####Step 2: Create a steps package
>Create page step classes, instantiate page classes, create step definitions & access page methods within these step
> definitions as:
> ````
> public class HomePageSteps {
> 
>    HomePage homePage = new HomePage();
>
>    @Step("Click category card named {}")
>    public void clickCategoryCard(String cardName) {
>        homePage.clickCategoryCardNamed(cardName);
>    }
> }
> ````
>Set Gauge @BeforeSpec & @AfterSpec steps in a different class as:
> ````
>   public class Initialize extends Utilities {
>
>       PropertiesReader reader = new PropertiesReader("properties-from-pom.properties");
>       StringUtilities strUtils = new StringUtilities();
>       Driver driver = new Driver();
>
>       @BeforeSpec
>        public void init(){
>           String browser = reader.getProperty("browser");
>           driver.setup(strUtils.firstLetterCapped(browser));
>       }
>
>       @AfterSpec
>       public void terminate(ExecutionContext context){
>           if (context.getCurrentSpecification().getIsFailing())
>               captureScreen(context.getCurrentSpecification().getName());
>           driver.teardown();
>       }
>   }
>````
> This will initialize the driver before each run, and kill it after each scenario is done. It will also
> capture a ss if the scenario fails, indicating scenario name and failed step info.

####Step 3: Create a spec package
>Create _**.spec**_ files, create your scenarios using the steps you have implemented in ***Step 2***.

####Step 4: Execute your tests
>The library allows the browser type to be designated on runtime, just pass:
> ````
> -Dbrowser=browserName
> ````
> For instance:
>````
> -Dbrowser=firefox
>````
>Chrome, Firefox, Opera, Edge & Safari are supported.
>In order to use this feature, please add the following plugin & property to your pom.xml:


    <properties>
        <browser>Chrome</browser>
        <name>${project.name}</name>
    </properties>
___

    <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>properties-maven-plugin</artifactId>
        <version>1.0.0</version>
        <executions>
            <execution>
                <phase>generate-resources</phase>
                    <goals>
                        <goal>write-project-properties</goal>
                    </goals>
                    <configuration>
                        <outputFile>${project.build.outputDirectory}/properties-from-pom.properties</outputFile>
                    </configuration>
            </execution>
        </executions>
    </plugin>
___ 
>It is recommended to use ***Gauge Maven Plugin*** which allows you to execute tests simultaneously on parallel.
> If you would like to do that, add plugin:

            <plugin>
                <groupId>com.thoughtworks.gauge.maven</groupId>
                <artifactId>gauge-maven-plugin</artifactId>
                <version>1.4.3</version>
                <executions>
                    <execution>
                        <phase>test</phase>
                        <configuration>
                            <specsDir>specs</specsDir>
                        </configuration>
                        <goals>
                            <goal>execute</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
####Example execution command:
>In order to execute a specific feature file in a specific browser, use:
>```
>mvn gauge:execute -DspecsDir=specs/example.spec -DinParallel=true -Dbrowser=chrome
>```
