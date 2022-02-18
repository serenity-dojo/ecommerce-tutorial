package ecommerce.screenplay.cart;

import ecommerce.screenplay.search.DisplayedProduct;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Button;

public class AddToCart {
    private static final SearchableTarget ADD_TO_CART_BUTTON = Button.locatedBy(".add-to-cart");

    public static Performable theItemCalled(String itemTitle) {
        return Task.where("{0} adds the '" + itemTitle + "' to the cart",
                actor -> {
                    actor.attemptsTo(
                            Click.on(ADD_TO_CART_BUTTON.inside(DisplayedProduct.SUMMARY.containingText(itemTitle))),
                            Click.on(Button.withText("Continue Shopping"))
                    );
                });
    }
}
