package jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Login {
    @Test
    public void LoginOnlyWithLoginfield() {
        System.out.println("1 Test - jenkins.Login only with User Id field");
       // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //открытие на всю страницу
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/");
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("btnLogin")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/Agile_Project/Agi_V1/index.php");
        driver.quit();

    }
    @Test
    public void LoginOnlywithPassfield() {
        System.out.println("2 Test - jenkins.Login only with Password field");
       // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //открытие на всю страницу
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("btnLogin")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/Agile_Project/Agi_V1/index.php");
        driver.quit();

    }
    @Test
    public void WithEmptyFields() {
        System.out.println("3 Test - jenkins.Login with empty fields");
      //  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //открытие на всю страницу
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/");
        driver.findElement(By.name("btnLogin")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/Agile_Project/Agi_V1/index.php");

        driver.quit();

    }
    @Test
    public void ResetData() {  //positive test
        System.out.println("4 Test - Reset User Id and Password fields");
       // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //открытие на всю страницу
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/");
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("btnReset")).click();
        driver.findElement(By.xpath("//label[@id='message23']")); //находим на страничке что он появился

        assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/Agile_Project/Agi_V1/");

        driver.quit();
        System.out.println("The data you entered has been cleared");

    }
    @Test
    public void WrongUserIdandPass() {
        System.out.println("5 Test - Not valid User Id and Password fields");
       // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/");
        driver.findElement(By.name("uid")).sendKeys("11111");
        driver.findElement(By.name("password")).sendKeys("2222");
        driver.findElement(By.name("btnLogin")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/Agile_Project/Agi_V1/index.php");
        driver.quit();
    }
    @Test
    public void RequiredUseridField() {
        System.out.println("6 Test -Appearance of a message User-ID must not be blank");
      //  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/");
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("uid")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("uid")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("uid")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("uid")).sendKeys(Keys.BACK_SPACE);
        WebElement Userblank = driver.findElement(By.xpath("//label[@id='message23']")); //находим на страничке что он появился
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(true, Userblank.isDisplayed());
        System.out.println("6 Test - Message shown: User-ID must not be blank");
        driver.quit();
    }

    @Test
    public void RequiredPassidField() {
        System.out.println("7 Test -Appearance of a message Password must not be blank");
      //  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/Agile_Project/Agi_V1/");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("password")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("password")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("password")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("password")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("password")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("password")).sendKeys(Keys.BACK_SPACE);
        WebElement Passblank = driver.findElement(By.xpath("//label[@id='message18']")); //находим на страничке что он появился
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(true, Passblank.isDisplayed());
        System.out.println("7 Test - Message shown: Password must not be blank");
        driver.quit();




    }

}
