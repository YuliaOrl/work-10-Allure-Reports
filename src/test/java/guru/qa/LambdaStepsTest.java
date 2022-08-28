package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsTest {

    private static final String REPOSITORY = "qa-guru/allure-notifications";
    private static final String ISSUENAME = "Too many logs. Add debug logging mode";

    @Test
    public void lambdaIssueNameCheckTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу github.com", () -> {
            open("https://github.com");
        });
        step("Ищем на странице github.com репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем страницу с разделом Issues ", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем в репозитории название Issue " + '"' + ISSUENAME + '"', () -> {
            $("#issue_92_link").shouldHave(text(ISSUENAME));
        });
    }
}
