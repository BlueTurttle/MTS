package pages.desktop;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MtsDengiPage {
    private final SelenideElement procentText = $x("//*[@id=\"__next\"]/div[4]/div[2]/div/div/div[3]/div/div[2]/div/ul/li[1]/div[2]/div");
    private final SelenideElement kashbackText = $x("//*[@id=\"__next\"]/div[4]/div[2]/div/div/div[4]/div[3]/div[1]/div[2]/div[1]/div/h4");

    public void openPage (String url) {
        Selenide.open(url);
    }

    public String getProcent () {
        return procentText.getText();
    }

    public String getKashback () {
        return kashbackText.getText();
    }
}