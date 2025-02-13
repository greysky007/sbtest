package page;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class GoogleResultPage {

    private final SelenideElement sberLink = $x("//h3[contains(text(),'СберЛизинг — официальный сайт лизинговой компании. Лизинг ...')]");

    public SberMainPage openTargetLink() {
        Selenide.actions().moveToElement(sberLink).click().perform();
        return new SberMainPage();
    }

}
