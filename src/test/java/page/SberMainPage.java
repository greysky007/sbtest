package page;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;


import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class SberMainPage {
    private final SelenideElement selectByParamButton = $x("//div[contains(@class, 'text-center')]/a[contains(text(), 'Подобрать по параметрам')]");
    private final SelenideElement acceptCookieButton = $x("//button[text()=' Принять всё ']");

    private final SelenideElement citySelect = $x("//label[contains(@aria-label, 'Город')]");
    private final ElementsCollection allCities = $$x("   //label[contains(@aria-label, 'Город')]/following-sibling::*/div/div");
    private final SelenideElement brandSelect = $x("//label[contains(@aria-label, 'Марка')]");
    private final ElementsCollection allBrands = $$x("   //label[contains(@aria-label, 'Марка')]/following-sibling::*/div/div");
    private final SelenideElement modelSelect = $x("//label[contains(@aria-label, 'Модель')]");
    private final ElementsCollection allModels = $$x("   //label[contains(@aria-label, 'Модель')]/following-sibling::*/div/div");

    private final SelenideElement checkBox = $x("//label[contains(@class, 'sbl-filter-checkbox') and contains(text(), 'Омск')]");
    private final SelenideElement engineCapacityFrom = $x("//div[contains(text(),'Объём двигателя')]/..//div[@class='range-slider-values__left']");
    private final SelenideElement engineCapacityTo = $x("//div[contains(text(),'Объём двигателя')]/..//div[@class='range-slider-values__right']");

    private final SelenideElement colorInput = $x("//input[@placeholder='Выберите или введите']");
    private final SelenideElement showAllOffer = $x("//a[text()=' Показать все предложения ']");
    private final ElementsCollection driveCheckBoxList = $$x("//div[contains(text(), 'Привод')]/..//div[@class='horizontal-filter-block__checkboxes-item custom-control custom-checkbox']");
    private final ElementsCollection transmissionCheckBoxList = $$x("//div[contains(text(), 'Коробка передач')]/..//div[@class='horizontal-filter-block__checkboxes-item custom-control custom-checkbox']");
    private final ElementsCollection fuelCheckBoxList = $$x("//div[contains(text(), 'Тип топлива')]/..//div[@class='horizontal-filter-block__checkboxes-item custom-control custom-checkbox']");
    private final ElementsCollection bodyTypeCheckBoxList = $$x("//div[contains(text(), 'Тип кузова')]/..//div[@class='checkboxes-body-type__checkbox']");
    private final ElementsCollection colorCheckBoxList = $$x("//input[@placeholder='Выберите или введите']/../..//div[@class='sbl-filter-checkbox sbl-filter-checkbox_group']");
    private final ElementsCollection fromAndToCostList = $$x("//span[@class='slider-min-max fs-14']");
    private final ElementsCollection fromAndToEnginePowerList = $$x("//div[contains(text(),'Мощность двигателя')]/..//span[@class='slider-min-max']");
    private final ElementsCollection fromAndToEngineCapacityList = $$x("//div[contains(text(),'Объём двигателя')]/..//span[@class='slider-min-max']");


    public SelenideElement getCheckBox(String city) {
        return $(By.xpath("//label[contains(@class, 'sbl-filter-checkbox') and contains(text(), '" + city + "')]"));
    }


    public int getRandomNumForCollection(ElementsCollection elements) {
        return new Random().nextInt(elements.size());

    }

    public SberMainPage acceptCookie() {
        acceptCookieButton.shouldBe(Condition.visible).scrollTo().hover().click();
        return this;
    }

    public SberMainPage selectByParam() {

        selectByParamButton.scrollTo().shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return new SberMainPage();
    }

    public SberMainPage openCityList(){
        citySelect.scrollTo().shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }
    public SberMainPage checkRandomCity(){
       int randomNum = getRandomNumForCollection(allCities);
        allCities.get(randomNum).shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }
    public SberMainPage openBrandList(){
        brandSelect.scrollTo().shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }
    public SberMainPage checkRandomBrand(){
        int randomNum = getRandomNumForCollection(allBrands);
        allBrands.get(randomNum).shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }
    public SberMainPage openModelList(){
        modelSelect.scrollTo().shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }
    public SberMainPage checkRandomModel(){
        int randomNum = getRandomNumForCollection(allModels);
        allModels.get(randomNum).shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;

    }



}
