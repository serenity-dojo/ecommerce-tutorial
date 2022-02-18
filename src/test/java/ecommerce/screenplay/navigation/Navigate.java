package ecommerce.screenplay.navigation;

import ecommerce.screenplay.catalog.AvailableCategories;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {
    public static Performable toTheHomePage() {
        return Open.url("https://automationexercise.com/");
    }

    public static Performable toTheProductPage() {
        return Open.url("https://automationexercise.com/products");
    }

    public static Performable toTheCategory(String category, String subcategory) {
        return Task.where("{0} opens the {0}/{1} category",
                actor -> {
                    actor.attemptsTo(AvailableCategories.openCategoryMenu(category));
                    actor.attemptsTo(AvailableCategories.openSubcategory(subcategory));
                }
        );
    }

    public static Performable toTheShoppingCart() {
        return Open.url("https://automationexercise.com/view_cart");
    }
}
