import io.qameta.allure.Description;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class QaAutomationTestPageTests extends BrowserSettings {

    public final String page = "https://docs.google.com/forms/d/1dgFKz9AD32hq326wnGaeFw6YccoNuzxwdVPFVb4UeXE/viewform?edit_requested=true";
    public final String eMail = "test4545@mail.ru";

    @Step("Предусловия")
    @BeforeEach
    public void precondition() {
        System.out.println("test");
    }

    @Step("Постусловия")
    @AfterEach
    public void aftercondition() {
        System.out.println("test");
    }

    @Test
    @Description("Проверка формы ")
    public void test() throws InterruptedException {
        new QaAutomationTestPage()
                .openPage(page)

                .clickButton("Отправить");

    }
}
