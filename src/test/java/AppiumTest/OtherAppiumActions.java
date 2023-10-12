package AppiumTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OtherAppiumActions extends BaseTest {

    @Test
    public void PortraitOrientation() {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        //Создаём объект для поворота экрана на 90 градусов(альбомный режим)
        DeviceRotation landscape = new DeviceRotation(0, 0, 90);

        //Переворачиваем экран на 90 градусов
        driver.rotate(landscape);

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

        //Добавляем в буфер обмена текст
        driver.setClipboardText("TestWifi");

        //Вставляем в текстовое поле текст из буфера обмена
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }

    @Test
    public void BackAndHomeButton() {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        //Нажимаем системную кнопку назад
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //Нажимаем системную кнопку домой
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

        //Кликаем энтер
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER));

    }


    @Test
    public void newActivityTest() {

        //Создаем объект активности нужного нам экрана
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");

        //Открываем нужную активность
        driver.startActivity(activity);

        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        //System.out.println(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText());
        driver.findElement(By.id("android:id/edit")).sendKeys("TestWifi");
        String alertInfo = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertInfo, "WiFi settings");
        //driver.findElement(AppiumBy.id("android:id/button1")).click();
        //Находим 2 элемента с одинаковым названием класса и получает элемент с индексом 1
        driver.findElements(By.className("android.widget.Button")).get(1).click();


    }
}


