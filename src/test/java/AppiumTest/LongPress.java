package AppiumTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends BaseTest {

    @Test
    public void LongPressGesture() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        //Находим элемент сплывающего окна и делаем на нем долгое нажатие
        //https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        //Запускаем метод долгого нажатия
        longPressAction(ele);

        //Получаем текст первого элемента
        String menuText = driver.findElement(By.id("android:id/title")).getText();

        //Проверяем правильность текста
        Assert.assertEquals(menuText, "Sample menu");

        //Похожая проверка. Проверяет отображается ли элемент на странице
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());






    }

}
