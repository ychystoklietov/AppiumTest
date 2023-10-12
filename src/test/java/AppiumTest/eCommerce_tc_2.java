package AppiumTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_2 extends BaseTest {

    @Test
    public void calculatedPrice() throws InterruptedException {

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

        //Кликаем первый товр "Add to cart"
        //driver.findElements(By.xpath("android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        //Другой способ кликнуть первый товар "Add to cart"
        driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
        //Кликаем второй товар "Add to cart"
        //Кликаем такой же хpath, потому что после нажатия на первый элемент индекс поменяеться
        driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
        //Переходим в корзину
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        //Создаём объект ожидания 5 секунд
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(15));
        //Ждем пока не появиться нужный аттрибует(Корзина)
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        //Записываем в список цены товаров в корзине
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        //Получаем количество элементов в списке
        int productPricesCount = productPrices.size();

        double totalSum = 0;

        for (int i = 0; i < productPricesCount; i++) {

            //Получаем текст элементов в списке(корзине)
            String amountString = productPrices.get(i).getText();
            //Удаляем значок долара из текста и превращаем строку в Double и записываем в переменную
            double price = getFormattedAmount(amountString);
            //Складываем две цены товаров в корзине
            totalSum = totalSum + price;

        }

        //Записываем общую цену отображающуюся в корзине
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

        //Записываем сумму в переменную и форматируем с помощью метода
        double displayFormattedSum = getFormattedAmount(displaySum);

        //Проверяем, что актуальная сумма совпадает с посчитаной
        Assert.assertEquals(totalSum, displayFormattedSum);

        //Зажимаем кнопку регламента
        longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
        //Берем заголовк алерта
        String titleTerms = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
        //Проверяем, что заголовок алерта совпадает
        Assert.assertEquals(titleTerms, "Terms Of Conditions");

        //Закрывам попап с регламентом
        driver.findElement(By.id("android:id/button1")).click();


        //Отмечаем чекбокс
        driver.findElement(By.className("android.widget.CheckBox")).click();
        //Кликаем купить
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(2000);


    }









}
