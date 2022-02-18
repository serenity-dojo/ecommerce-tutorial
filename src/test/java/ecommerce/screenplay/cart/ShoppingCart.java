package ecommerce.screenplay.cart;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

public class ShoppingCart {
    public static Question<Collection<String>> CART_ITEM_TITLES = Text.ofEach(".cart_description a");
}
