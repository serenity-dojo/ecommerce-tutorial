package ecommerce.features.catalog;

import ecommerce.screenplay.catalog.AvailableCategories;
import ecommerce.screenplay.catalog.DisplayedProducts;
import ecommerce.screenplay.navigation.Navigate;
import ecommerce.screenplay.search.DisplayedProduct;
import ecommerce.screenplay.search.SearchProducts;
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
class WhenSearchingForProducts {

    @CastMember
    Actor shane;

    @BeforeEach
    void shaneOpensTheProductPage() {
        shane.attemptsTo(Navigate.toTheProductPage());
    }

    @ParameterizedTest(name = "{index}: Search for {0}")
    @CsvSource(value = {
            "blue",
            "cotton",
            "linen",
    })
    void searchingForAProductByKeyword(String keyword) {
        shane.attemptsTo(
                SearchProducts.byKeyword(keyword),
                Ensure.that(DisplayedProduct.titles()).allMatch("Contain the word '" + keyword + "'",
                        title -> title.toLowerCase().contains(keyword)
                )
        );
    }

}