import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChatParser {

    public static void main(String[] args) {
        try {
            // Получение содержимого чата
            Document doc = Jsoup.connect("https://kick.com/chimp").get();
            Elements messages = doc.select("chat-message-identity"); // Замените ".message" на реальный селектор элемента сообщения

            for (Element message : messages) {
                String messageContent = message.text();
                if (messageContent.startsWith("MELL")) {
                    // Вставка сообщения на сайт vavada в окно промокода
                    System.setProperty("webdriver.chrome.driver", "путь_к_вашему_драйверу/chromedriver");
                    WebDriver driver = new ChromeDriver();
                    driver.get("https://vavadajhc.com/ru/profile/bonus/");
                    WebElement promoCodeInput = driver.findElement(By.id("promo_code_token")); // Замените "promo-code-input" на реальный id ввода промокода
                    promoCodeInput.sendKeys(messageContent);
                    // Другие действия, если необходимо
                    driver.quit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}