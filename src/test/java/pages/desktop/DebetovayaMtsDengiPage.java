package pages.desktop;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class DebetovayaMtsDengiPage {
    private final SelenideElement phoneNumberEntry = $x("//*[@id=\"cardFormInput\"]");
    private final SelenideElement fioEntry = $x("//textarea[@placeholder='Иванов Иван Иванович']");
    private final SelenideElement mailEntry = $x("//input[@type='email']");
    private final SelenideElement nextButton = $x("//*[@id=\"issueCard\"]/div[2]/div/div/div/div/form/div/div[2]/div/div/div[6]/span/button");
    private final SelenideElement kodText = $x("//*[@id=\"issueCard\"]/div[2]/div/div/div/div/form/div/div/div/span/h3/span");


    public void changePhone(String phone) {
        phoneNumberEntry.setValue(phone);
    }

    public void clickOnFio() {
        fioEntry.click();


    }
    public void sendFio(String fio) {
        Selenide.sleep(2000);
        fioEntry.sendKeys(fio);
        fioEntry.sendKeys(Keys.ENTER);
    }

    public void changeMail(String mail) {
        mailEntry.setValue(mail);
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public String getKodText() {
        return kodText.getText();
    }
}
