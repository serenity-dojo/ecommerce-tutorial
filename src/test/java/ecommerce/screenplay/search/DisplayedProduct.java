package ecommerce.screenplay.search;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.PageElement;

import java.util.Collection;
import java.util.List;

public class DisplayedProduct {

    public static final SearchableTarget SUMMARY = PageElement.locatedBy(".productinfo").called("Product summary");
    private static final String PRODUCT_TITLE = ".productinfo p";

    public static Question<Collection<String>> titles() {
        return Text.ofEach(PRODUCT_TITLE);
    }


}
