import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ElementsTests {
    public ElementsTests(){
        Configuration.timeout=10000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
    }
    @BeforeMethod
    public void openLink() {
        open("https://demoqa.com/");
    }
    @Test
    public void FirstTest() throws InterruptedException {
        $(".top-card").click();
        $("#item-2").click();
        $("#impressiveRadio").click();
        $(byText("You have selected Impressive")).should(appear);
//        $(".text-success").shouldHave(exactText("You have selected Impressive"));
    }
    @AfterMethod
    public void closeTab() {
        closeWebDriver();
        System.out.println("after method");
    }

    @Test
    public void SecondTest(){
        $(".top-card").click();
        $("#item-4").click();
        $("#6d2Xf").click();
        $(byText("You have done a dynamic click")).should(appear);
        $("#rightClickBtn").click();
        $(byText("You have done a right click")).should(appear);
    }

}
