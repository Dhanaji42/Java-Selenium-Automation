package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.BaseClass;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        String path = System.getProperty("user.dir")
                + "\\Screenshots\\"
                + testName + ".png";

        try {

            File src = ((TakesScreenshot) BaseClass.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, new File(path));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }

}
