package baidu;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baidu {
    public static void open(){
	WebDriver driver= new FirefoxDriver();
	driver.get("https://www.baidu.com");
    }
 }


