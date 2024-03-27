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


class CallbackSelenideTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("form");

        form.find("[data-test-id=name] input").setValue("Василий");
        form.find("[data-test-id=phone] input").setValue("+79270000000");
        form.find("[data-test-id='agreement']").click();
        form.find("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}