package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {


    private final SelenideElement inputField = $x("//textarea[contains(@title, 'Поиск')]");
    private final SelenideElement searchButton = $x("//input[@value='Поиск в Google'and@role='button']");


    public GoogleResultPage getSearchPage(String query) {
        inputField.setValue(query);
        Selenide.sleep(2000);
        searchButton.pressEnter();
        return new GoogleResultPage();
    }

}
