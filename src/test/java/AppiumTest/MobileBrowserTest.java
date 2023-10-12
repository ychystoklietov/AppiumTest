package AppiumTest;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBaseTest {

    @Test
    public void browserTest() {

        //Открыаем страницу в мобильном браузере
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        //Получаем название страницы
        driver.getTitle();
        //Проверяем, что бургер меню отображается
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class=\"navbar-toggler\"]")).isDisplayed());
        //Кликаем на бургер меню
        driver.findElement(By.xpath("//button[@class=\"navbar-toggler\"]")).click();
        //Кликаем продукты
        driver.findElement(By.xpath("//a[@routerlink=\"/products\"]")).click();
        //Скролим экран в самый низ
        scrollDown();
        //Записываем название ссылки в переменную
        String actualResult = driver.findElement(By.linkText("Devops")).getText();
        //Проверяем что название правильное
        Assert.assertEquals(actualResult, "Devops");
        //Клац ссылку
        driver.findElement(By.linkText("Devops")).click();









    }


}
