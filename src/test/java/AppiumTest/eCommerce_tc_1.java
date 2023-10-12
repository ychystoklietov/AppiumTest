package AppiumTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_tc_1 extends BaseTest {

    @Test
    public void FillForm() throws InterruptedException {

        //Вводим имя в поле Name
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TestName");
        //Закрываем клавиатуру
        driver.hideKeyboard();
        //Выбираем нужный чекбокс
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        //Клиаем на выбор страны
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        //Скролим экран до нужной страны
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Bahamas\"));"));
        //Выбираем нужную страну
        driver.findElement(By.xpath("//android.widget.TextView[@text='Bahamas']")).click();
        //Кнопка входа
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //Скролим до нужных кросовок
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Jordan 6 Rings\"));"));

        //Находим все продкуты на странице и получаем их количество
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        //Запускаем цикл по всем продуктам в списке
        for (int i = 0; i < productCount; i++) {

            //Записываем в переменную название продуктов
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            //Если в списке появляеться нужный продукт кликаем "Добавить в корзину"
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {

                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        //Клик на значок корзины
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //Создаём объект ожидания 5 секунд
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(5));

        //Ждем пока не появиться нужный аттрибует(Корзина)
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        //Берем название товара в корзине
        String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

        //Проверям, что в корзину добавлен действительно нужный продукт
        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");


    }

    @Test
    public void invalidLogin() {

        //Нажимаем кнопку купить
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //Сохраняем значинем тоаста об ошибке
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        //Проверяем что сообщение на тоасте правильное
        Assert.assertEquals(toastMessage, "Please enter your name");


    }



}
