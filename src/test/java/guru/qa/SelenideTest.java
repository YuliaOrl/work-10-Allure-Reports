package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void issueNameCheckTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").sendKeys("qa-guru/allure-notifications");
        $(".header-search-input").submit();
        $(linkText("qa-guru/allure-notifications")).click();
        $("#issues-tab").click();
        $("#issue_92_link").shouldHave(text("Too many logs. Add debug logging mode"));
    }
}
