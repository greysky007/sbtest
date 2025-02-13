import com.sun.tools.javac.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import page.MainPage;

import java.util.Arrays;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;

public class UITEst {

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities.setCapability("goog:chromeOptions", new HashMap<String, Object>() {{
            put("args", Arrays.asList("--disable-blink-features=AutomationControlled"));
        }});

        Configuration.headless = false;
        Configuration.timeout = 10000;

        open("https://google.com");
    }

    @AfterEach
    public void setDown() {
        closeWindow();
        closeWebDriver();
    }


    @Test
    public void shouldTest() {
        var page = new MainPage();

        page.getSearchPage("СберЛизинг")
                .openTargetLink()
                .acceptCookie()
                .selectByParam()
                .openCityList()
                .checkRandomCity()
                .openBrandList()
                .checkRandomBrand()
                .openModelList()
                .checkRandomModel();


    }
}
