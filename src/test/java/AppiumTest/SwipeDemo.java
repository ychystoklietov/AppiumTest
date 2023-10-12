package AppiumTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest {

    @Test
    public void SwipeDemoTest() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"1. Photos\"]")).click();

        //Указываем локатор первого элемента в переменную
        WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));

        //Проверяем, что первая фотография имеет атрибут focusable на True
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]"))
                .getAttribute("focusable"), "true");

        //Указываем какой элемент свайпаем и в какую сторону
        SwipeAction(firstImage, "left");

        //Проверяем что свайп сработал и атрибует элемента изменился
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]"))
                .getAttribute("focusable"), "false");



    }



}
