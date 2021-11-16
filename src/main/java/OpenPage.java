import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OpenPage {
    SelenideElement vartist = $(byText("Вартість доставки"));
    SelenideElement mistoVidpravky = $("#DeliveryForm_senderCity");
    SelenideElement kyiv = $(byText("м. Київ, Київська обл."));
    SelenideElement mistoOderzh = $("#DeliveryForm_recipientCity");
    SelenideElement vinnytsia = $(byText("м. Вінниця, Вінницька обл."));
    SelenideElement ogoloshenaVartist = $(byName("DeliveryForm[optionsSeat][1][cost]"));
    SelenideElement vaga = $(byName("DeliveryForm[optionsSeat][1][weight]"));
    SelenideElement dovzhina = $(byName("DeliveryForm[optionsSeat][1][volumetricLength]"));
    SelenideElement shirina = $(byName("DeliveryForm[optionsSeat][1][volumetricWidth]"));
    SelenideElement vysota = $(byName("DeliveryForm[optionsSeat][1][volumetricHeight]"));
    SelenideElement rozrah = $(".btn.submit");
    SelenideElement pidjom = $("#DeliveryForm_floorCountAsc");


    @Before
    public void setUp(){
        holdBrowserOpen = true;
        open("https://novaposhta.ua");
        getWebDriver().manage().window().maximize();
    }

    @Test
    public void calculate(){
        vartist.click();
        mistoVidpravky.sendKeys("Київ");
        kyiv.click();

        mistoOderzh.sendKeys("Вінниця");
        vinnytsia.click();

        ogoloshenaVartist.sendKeys("100");
        vaga.sendKeys("3");
        dovzhina.sendKeys("30");
        shirina.sendKeys("50");
        vysota.sendKeys("10");
        pidjom.sendKeys("6");

        rozrah.click();
    }
}
