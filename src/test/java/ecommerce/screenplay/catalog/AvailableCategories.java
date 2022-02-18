package ecommerce.screenplay.catalog;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.PageElement;
import java.util.Collection;

public class AvailableCategories {

    private static final String MENU_ENTRY = ".category-products .panel";
    private static final String CATEGORY_TITLE = ".category-products .panel-title a";
    private static final String SUBCATEGORY_TITLE = ".category-products .panel-body a";

    public static Question<Collection<String>> currentlyVisible() {
        return Text.ofEach(CATEGORY_TITLE).mapEach(String::trim);
    }

    public static Performable openCategoryMenu(String category) {
        return Click.on(categoryMenu(category));
    }

    public static Performable openSubcategory(String subcategory) {
        return Click.on(subcategoryMenu(subcategory));
    }

    public static SearchableTarget categoryMenu(String subcategoryName) {
        return PageElement.locatedBy(CATEGORY_TITLE).containingText(subcategoryName);
    }

    public static SearchableTarget subcategoryMenu(String subcategoryName) {
        return PageElement.locatedBy(SUBCATEGORY_TITLE).containingText(subcategoryName);
    }
}
