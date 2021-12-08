import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage extends BaseTest {
    final static Logger logger = Logger.getLogger(BasePage.class.getName());
    @Step("<wait> saniye bekle")
    public void waitSecond(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
        logger.info(wait + "süre beklendi");

        }

    @Step("<idClick> id'li elemante tıkla")
    public void clickToId(String idClick) {
        appiumDriver.findElement(By.id(idClick)).click();
        logger.info("ID Elementine Tıklandı");
    }

    @Step("<xpathClick> xpath elementine tıkla")
    public void clickToXpath(String xpathClick) {
        appiumDriver.findElement(By.xpath(xpathClick)).click();
        logger.info("Xpath Elementine tıklandı");
    }

    @Step("Scrolldown yapılır")
    public void scrollDown() {
        int startX = 540;
        int startY = 1960;
        int endX = 541;
        int endY = 400;
        TouchAction action = new TouchAction(appiumDriver);
        action.press(point(startX, startY))
                .moveTo(point(endX, endY))
                .release()
                .perform();
        logger.info("Scroll yapıldı");

    }

    @Step("<random> RANDOM elemente tıklandı")
    public void randomSelect(String random) {
        List<MobileElement> elements = appiumDriver.findElementsById(random);
        Random rnd = new Random();
        int rndInt = rnd.nextInt(elements.size());
        elements.get(rndInt).click();
        logger.info("random seçim yapıldı");
    }

    @Step("<id> id'li elemete <text> text değerini yaz")
    public void sendKey(String id, String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        logger.info("Deger yazıldı");
    }
    @Step("<key> id'li element <keyword> text değerini içerdiğni kontrol et")
    public void assertControlId(String key,String keyword){
        Assert.assertTrue("Doğrulama yapılamadı",appiumDriver.findElement(By.id(key)).getText().contains(keyword));
        logger.info("Id ile Kontrol yapıldı");
    }
    @Step("<keyXpath> xpath element <keywordXpath> text değerini içerdiğni kontrol et")
    public void assertControlXpath(String keyXpath,String keywordXpath){
        Assert.assertTrue("Doğrulama yapılamadı",appiumDriver.findElement(By.xpath(keyXpath)).getText().contains(keywordXpath));
        logger.info("Xpath ile Kontrol yapıldı");
    }

}