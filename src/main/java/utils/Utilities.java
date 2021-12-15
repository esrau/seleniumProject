package utils;

import utils.driver.Driver;

public class Utilities extends Driver{

    public void navigate(String url)
    {
        driver.get(url);
    }
    public void waitFor(double seconds) {
        try {Thread.sleep((long) (seconds*1000));}
        catch (InterruptedException ignored){}
    }
}
