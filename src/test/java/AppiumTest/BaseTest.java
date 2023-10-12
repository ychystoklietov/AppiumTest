package AppiumTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Объявляем глобальный объект для всего класса
    public static AndroidDriver driver;

    //public AppiumDriverLocalService service;
    @BeforeTest
    public void ConfigureAppium() throws MalformedURLException {

        //Создаем объект для запуска сервера апиум. Указываем путь к апуму, адрес сервера и порт
        //AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\chesk\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
        //.withIPAddress("127.0.0.1").usingPort(4723).build();
        //Запускаем апиум
        //service.start();

        //Создаем объект настроек апиум
        UiAutomator2Options options = new UiAutomator2Options();
        //Указываем имя устройства
        options.setDeviceName("Pixel 7 API 30");
        //Указываем путь к хромдрайверу для дестов веб
        options.setChromedriverExecutable("C:\\webdriversEmulator\\chromedriver.exe");
        //Указываем путь к тестовому приложению
        //options.setApp("D:\\Automates\\ApiumTest\\src\\test\\java\\resources\\ApiDemos-debug.apk");

        //Указываем путь к тестовому приложению-магазину
        options.setApp("D:\\Automates\\ApiumTest\\src\\test\\java\\resources\\General-Store.apk");

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

    //Метод для долгого нажатия на элемент
    public void longPressAction(WebElement ele) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"duration", 2000));

    }

    //Метод для медленного прокручивания экрана вниз
    public void scrollToEndAction() {

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while (canScrollMore);
    }

    //Указываем, что в методе свайпа будет элмент и направление
    public void SwipeAction(WebElement ele, String direction) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    //Метод перятигивания на указанные координаты
    public void DragDropAction(WebElement source) {

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 612,
                "endY", 626
        ));
    }

    //Метод который убирает первый знак (долара) и форматирует число в Double
    public Double getFormattedAmount(String amount) {

        Double price = Double.parseDouble(amount.substring(1));
        return price;

    }



}


