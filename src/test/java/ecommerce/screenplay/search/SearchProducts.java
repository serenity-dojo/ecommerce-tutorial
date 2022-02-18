package ecommerce.screenplay.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;

public class SearchProducts {

    private static final String SEARCH_ICON = "fa-search";

    public static Performable byKeyword(String keyword) {
        return Task.where("{0} searches for products by keyword " + keyword,
                Enter.theValue(keyword).into(InputField.withPlaceholder("Search Product")),
                Click.on(Button.withIcon(SEARCH_ICON))
        );
    }
}
