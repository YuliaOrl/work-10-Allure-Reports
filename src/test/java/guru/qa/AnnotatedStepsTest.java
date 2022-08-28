package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private static final String REPOSITORY = "qa-guru/allure-notifications";
    private static final String ISSUENAME = "Too many logs. Add debug logging mode";

    @Test
    public void annotatedStepIssueNameCheckTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsForAnnotatedTest steps = new StepsForAnnotatedTest();

        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openPageIssues();
        steps.checkIssueName(ISSUENAME);
    }
}
