package guru.qa;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsForAnnotatedTest {

    @Step("Открываем главную страницу github.com")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем на странице github.com репозиторий {repo}")
    public void searchRepository(String repo) {
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем страницу с разделом Issues")
    public void openPageIssues() {
        $("#issues-tab").click();
    }

    @Step("Проверяем в репозитории название Issue \"{name}\"")
    public void checkIssueName(String name) {
        $("#issue_92_link").shouldHave(text(name));
    }
}
