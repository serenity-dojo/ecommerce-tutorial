package ecommerce.screenplay.catalog;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class DisplayedProducts {

    public static Question<String> CATEGORY_TITLE = Text.of(".title");
}
