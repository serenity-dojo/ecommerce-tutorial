package ecommerce.features.cart;

import ecommerce.screenplay.cart.AddToCart;
import ecommerce.screenplay.cart.ShoppingCart;
import ecommerce.screenplay.navigation.Navigate;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.SingleBrowser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenAddingItemsToTheShoppingCart {

    @CastMember
    Actor shane;

    @BeforeEach
    void shaneNavigatesToTheWebsite() {
        shane.attemptsTo(Navigate.toTheHomePage());
    }

    @Test
    @Order(1)
    void addingASingleItem() {
        shane.attemptsTo(
                AddToCart.theItemCalled("Blue Top")
        );
        shane.attemptsTo(
                Navigate.toTheShoppingCart(),
                Ensure.that(ShoppingCart.CART_ITEM_TITLES).contains("Blue Top")
        );

    }

    @Test
    @Order(2)
    void addingMultipsItems() {
        shane.attemptsTo(
                AddToCart.theItemCalled("Blue Top"),
                AddToCart.theItemCalled("Sleeveless Dress")
        );
        shane.attemptsTo(
                Navigate.toTheShoppingCart(),
                Ensure.that(ShoppingCart.CART_ITEM_TITLES).contains("Blue Top", "Sleeveless Dress")
        );

    }

}