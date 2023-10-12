package AppiumTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileBaseTest {

    //Объявляем глобальный объект для всего класса
    public static AndroidDriver driver;

    //public AppiumDriverLocalService service;
    @BeforeTest
    public void ConfigureAppium() throws MalformedURLException {

        //Создаем объект настроек апиум
        UiAutomator2Options options = new UiAutomator2Options();
        //Указываем имя устройства
        options.setDeviceName("Pixel 7 API 30");
        //Указываем путь к хромдрайверу для дестов веб
        options.setChromedriverExecutable("C:\\webdriversEmulator\\chromedriver.exe");
        //Устанавливаем каким браузером будем пользоваться
        options.setCapability("browserName", "Chrome");
        //Создаем объект драйвера, в перееменные укзаваем адрес сервера апиум и настройки
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        //Устанавливаем ожидание 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {

        //Закрываем приложение
        driver.quit();
        //Останавливаем сервер appium
        //service.stop();

    }

    //Метод, который скролит страницу вниз
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }


}
