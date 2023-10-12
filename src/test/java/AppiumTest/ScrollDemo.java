package AppiumTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {

    @Test
    public void ScrollDemoTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Создаем объект скрола с помощью UiAutomator
        //Указываем до какого элемента будем скролить
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                //".scrollIntoView(text(\"WebView\"));"));

        //Метод скрола вниз
        scrollToEndAction();








    }

}
