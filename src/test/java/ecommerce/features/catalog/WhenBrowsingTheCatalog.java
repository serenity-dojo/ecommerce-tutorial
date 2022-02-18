package ecommerce.features.catalog;

import ecommerce.screenplay.catalog.AvailableCategories;
import ecommerce.screenplay.catalog.DisplayedProducts;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(SerenityJUnit5Extension.class)
@SingleBrowser
class WhenBrowsingTheCatalog {

    @CastMember
    Actor shane;

    @BeforeEach
    void shaneNavigatesToTheWebsite() {
        shane.attemptsTo(Navigate.toTheHomePage());
    }

    @Test
    @Order(1)
    void viewingAvailableProductCategories() {
        shane.attemptsTo(
                Ensure.that(AvailableCategories.currentlyVisible()).contains("WOMEN", "MEN", "KIDS")
        );
    }

    @ParameterizedTest(name = "{index}: {2}")
    @CsvSource(value = {
            "Kids,  Dress,  Kids - Dress Products",
            "Women, Dress,  Women - Dress Products",
            "Women, Saree,  Women - Saree Products",
            "Men,   Jeans,  Men - Jeans Products",
    })
    @Order(2)
    void viewProductsByCategoryAndSubcategory(String category, String subCategory, String expectedTitle) {
        shane.attemptsTo(
                Navigate.toTheCategory(category, subCategory),
                Ensure.that(DisplayedProducts.CATEGORY_TITLE).isEqualToIgnoringCase(expectedTitle)
        );
    }

}