import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingLogin {
    WebDriver driver;

    @Before
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        System.out.println("Открылся сайт https://www.booking.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[6]/a")).click();
        System.out.println("Нажата кнопка Войти");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys("garis465@gmail.com");
        System.out.println("Введен Email");
        driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys(Keys.RETURN);
        System.out.println("Нажата кнопка Enter");
        Thread.sleep(1000);
    }

    @Test
    public void testCorrectPassTest() throws InterruptedException {

        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys("HelloWorld");
        System.out.println("Введен корректный пароль");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys(Keys.RETURN);
        System.out.println("Нажата кнопка Enter");
        Thread.sleep(1000);
        Assert.assertNotNull( driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[6]/a/span[2]")) );
        System.out.println("Произошла проверка");

    }
    @Test
    public void testFailPassTest() throws InterruptedException {

        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys("12345");
        System.out.println("Введен не верный пароль");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys(Keys.RETURN);
        System.out.println("Нажата кнопка Enter");
        Thread.sleep(1000);
        Assert.assertNotNull( driver.findElement(By.xpath("/html//div[@id='password-error']")) );
        System.out.println("Произошла проверка");

    }
    @After
    public void quit(){
        driver.quit();
        System.out.println("Выход с драйвера");
    }
}
