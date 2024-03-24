// USING CASE SELENIDE

// load JAR-file: "java -jar artifacts/app-order.jar" before starting test

/* Поиск по селектору:
    1. По классу - ".название класса" (.name)
    2. По атрибуту - "[атрибут]" ([name=first_name])
    3. По id - "'#название'" ('#name')
    4. По тегу - "input" ($ один или $$ несколько)

    ***
    Simple селекторы можно выстраивать в последовательность, требуя соответствия всем селекторам, входящим в последовательность, например, input[type="search"] раскладывается на два simple:

    input (селектор по тегу)
    [type="search"] (селектор по значению атрибута)
* */
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/// Исходный тест
/*
 class CallbackTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[data-test-id=callback-form]");
        form.$("[data-test-id=name] input").setValue("Василий");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[data-test-id=submit]").click();
        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }
}*/

class CallbackSelenideTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        ElementsCollection form = $$("[data-test-id]");
        SelenideElement button = $("button");

        form.get(0).find("[data-test-id=name] input").setValue("Василий");
        form.get(1).find("[data-test-id=phone] input").setValue("+79270000000");
        form.get(2).click();
        button.click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}