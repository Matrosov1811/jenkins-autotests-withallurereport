package pav.matrosov;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {

    @Step("Открываем страницу и проверяем наличие заголовка {expectedResult}")
    public void openPageAndCheckHeader (String expectedResult) {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(expectedResult));
    }

    @Step("Вводим имя и фамилию")
    public void enterFirstAndLastName (String firstName, String lastName) {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
    }

    @Step("Вводим Email")
    public void enterEmail (String Email) {
        $("#userEmail").setValue(Email);
    }

    @Step("Заполняем остальные поля")
    public void enterAllFields () {
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1231231230");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("[aria-label$='July 30th, 2008']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue("Some address 1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();
    }

    @Step("Проверяем результат")
    public void checkResult () {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Alex Egorov"));
    }

}
