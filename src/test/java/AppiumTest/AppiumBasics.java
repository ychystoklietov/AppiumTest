package AppiumTest;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;



public class AppiumBasics extends BaseTest  {

    @Test
    public static void WifiSettingName() throws MalformedURLException {

        //Находим элемент и нажимам на него
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        //System.out.println(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText());
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("TestWifi");
        String alertInfo = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertInfo, "WiFi settings");
        //driver.findElement(AppiumBy.id("android:id/button1")).click();
        //Находим 2 элемента с одинаковым названием класса и получает элемент с индексом 1
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();




    }

}
