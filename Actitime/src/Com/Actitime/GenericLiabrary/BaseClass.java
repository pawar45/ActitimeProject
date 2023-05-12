package Com.Actitime.GenericLiabrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.Actitime.ObjectRepository.HomePage;
import Com.Actitime.ObjectRepository.Loginpage;

public class BaseClass {
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	
@BeforeSuite
public void databaseconnection() {
	Reporter.log("database connected",true);
}
@BeforeClass
public void launchBrowser() throws IOException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String URL = f.readDataFromPropertyFile("url");
	driver.get(URL);
	Reporter.log("browser launched",true);
}
@BeforeMethod
public void login() throws IOException {
	Loginpage lp=new Loginpage(driver);
	String un = f.readDataFromPropertyFile("username");
	String pw = f.readDataFromPropertyFile("password");
	lp.getUntb().sendKeys(un);
	lp.getPwtb().sendKeys(pw);
	lp.getLgbtn().click();
//	String un = f.readDataFromPropertyFile("username");
//	driver.findElement(By.id("username")).sendKeys(un);
//	String pw = f.readDataFromPropertyFile("password");
//	driver.findElement(By.name("pwd")).sendKeys(pw);
//	driver.findElement(By.xpath("//div[.='Login ']")).click();
	Reporter.log("logged in successfully",true);
}
@AfterMethod
public void logout() {
//	driver.findElement(By.linkText("Logout")).click();
	HomePage hp=new HomePage(driver);
	hp.getLogouttab().click();
	Reporter.log("logged out successfully",true);
}
@AfterClass
public void closebrowser() {
	driver.close();
	Reporter.log("browser closed",true);
}
@AfterSuite
public void databasedisconnection() {
	Reporter.log("database is disconnected",true);
}
@Test
public void addMe() {
	Reporter.log("nilesh is best",true);
}
}






