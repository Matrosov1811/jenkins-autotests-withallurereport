package pav.matrosov;

import org.junit.jupiter.api.Test;

public class AutomationPracticeForm extends TestBase {

    @Test
    void fillFormTest() {

        steps.openPageAndCheckHeader("Student Registration Form");
        steps.enterFirstAndLastName("Alex", "Egorov");
        steps.enterEmail("alex@egorov.com");
        steps.enterAllFields();
        steps.checkResult();
    }
}
