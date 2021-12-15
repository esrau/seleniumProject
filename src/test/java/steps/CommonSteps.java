package steps;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import pages.CommonPages;
import pages.Scenario1;
import utils.Utilities;

public class CommonSteps extends Utilities {

    CommonPages commonPages = new CommonPages();

    @Before
    public void startDriver()
    {
        initialize();
    }
    @After
    public void terminateDriver()
    {
       // terminate();
    }
    @Given("Navigate to {}")
    public void browserNavigate(String url)
    {
        navigate(url);
    }

    @Given("Wait for {}")
    public void browserNavigate(double duration)
    {
        waitFor(duration);
    }

}