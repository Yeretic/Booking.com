import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class booking {
    WebDriver driver;

    @Before
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        System.out.println("Открылся сайт https://www.booking.com/");
        Thread.sleep(1000);
    }

    @Test
    public void testSearchOdessaTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//input[@id='ss']")).clear();
        System.out.println("Поле очищено");
        driver.findElement(By.xpath("/html//input[@id='ss']")).sendKeys("Одеса");
        System.out.println("Введен текст Одеса в поле поиска");
        driver.findElement(By.xpath("/html//input[@id='ss']")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        System.out.println("нажата кнопка энтр");
        Assert.assertNotNull( driver.findElement(By.xpath("//*[@id=\"breadcrumb\"]/ol/li[5]/a/div")) );
        System.out.println("Произошла проверка");
    }


    @After
    public void quit(){
        driver.quit();
        System.out.println("Выход с драйвера");
    }
}
