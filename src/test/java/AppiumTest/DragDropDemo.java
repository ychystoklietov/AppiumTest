package AppiumTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropDemo extends BaseTest {

    @Test
    public void DragDropTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        //Находим элемент объекта который хотим перенести и записываем его в переменную
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        //Метод перетаскивания на координаты
        DragDropAction(source);

        //Записываем актуальные результат в переменную
        String actualResult = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();

        //Проверяем, что актуальный результат ясен ожидаемому
        Assert.assertEquals(actualResult, "Dropped!");








    }
}
