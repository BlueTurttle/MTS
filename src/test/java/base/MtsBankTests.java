package base;

import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;
import pages.desktop.*;

@Execution(ExecutionMode.CONCURRENT)
public class MtsBankTests extends BaseTest {

    //private final static String url = "https://www.mtsbank.ru/";


    @Test
    @Owner("Kochergin")
    @Description("Проверка текста")
    public void test1() {
        MainPage mainPage = new MainPage();
        mainPage.openPage("https://www.mtsbank.ru/");
        mainPage.hoverOnKarti();
        String a = mainPage.getProcent();
        String b = mainPage.getKashback();
        mainPage.clickOnKarta();

        MtsDengiPage mtsDengiPage = new MtsDengiPage();
        String a1 = mtsDengiPage.getProcent();
        String b1 = mtsDengiPage.getKashback();

        Assertions.assertEquals(b, b1);
        Assertions.assertTrue(a1.contains(a));
    }

    @ParameterizedTest
    @ValueSource(strings = {"9519998874", "9663488819"})
    public void test2(String phoneNumber) {
        MainPage mainPage = new MainPage();
        mainPage.openPage("https://www.mtsbank.ru/");
        mainPage.hoverOnSignInButton();
        mainPage.clickOnChastnLicamButton();
        SignInPage signInPage = new SignInPage();
        signInPage.changePhoneNuberEntry(phoneNumber);
        signInPage.clickOnNextButton();
        Assertions.assertEquals("Введите код из SMS", signInPage.getSuccesfulText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111111111", "5555555555"})
    public void test3(String phoneNumber) {
        MainPage mainPage = new MainPage();
        mainPage.openPage("https://www.mtsbank.ru/");
        mainPage.hoverOnSignInButton();
        mainPage.clickOnChastnLicamButton();
        SignInPage signInPage = new SignInPage();
        signInPage.changePhoneNuberEntry(phoneNumber);
        signInPage.clickOnNextButton();
        Assertions.assertEquals("Неправильный номер телефона", signInPage.getFailedText());

    }

    @ParameterizedTest
    @CsvSource({
            "9519898874, Петров Петр Петрович",
            "1234567890, Ф Ф Ф"
    })
    public void test4(String phone, String fio) {
        MainPage mainPage = new MainPage();
        mainPage.openPage("https://www.mtsbank.ru/");
        mainPage.clickOnDebetovieButton();
        DebetovieKartiPage debetovieKartiPage = new DebetovieKartiPage();
        debetovieKartiPage.clickOnMtsDengiButton();
        DebetovayaMtsDengiPage debetovayaMtsDengiPage = new DebetovayaMtsDengiPage();
        debetovayaMtsDengiPage.changePhone(phone);
        debetovayaMtsDengiPage.clickOnFio();
        debetovayaMtsDengiPage.sendFio(fio);
        int i = 0;
        debetovayaMtsDengiPage.changeMail("kkk@gmail.com");
        debetovayaMtsDengiPage.clickOnNextButton();
        Assertions.assertEquals("ВВЕДИТЕ КОД", debetovayaMtsDengiPage.getKodText());
    }

    @Test
    public void test5() {
        MainPage mainPage = new MainPage();
        mainPage.openPage("https://www.mtsbank.ru/");
        mainPage.clickOnRegionButton();
        mainPage.clickOnOficiBankomatiButton();
        OfisiBankomatiPage ofisiBankomatiPage = new OfisiBankomatiPage();
        ofisiBankomatiPage.clickOnSpiskomButton();
        ofisiBankomatiPage.clickOnPropertiesButton();
        ofisiBankomatiPage.clickOnKruglosutochnoButton();
        ofisiBankomatiPage.clickOnPropertiesButton();
        Assertions.assertEquals("Открыто", ofisiBankomatiPage.getOpenText());
    }

}


