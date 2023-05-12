package Com.Actitime.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Com.Actitime.GenericLiabrary.BaseClass;
import Com.Actitime.ObjectRepository.HomePage;

public class Task extends BaseClass{
@Test
public void createCustomer() {
	HomePage hp=new HomePage(driver);
	hp.getTasktab().click();
	hp.getReporttab().click();
	hp.getUsertab().click();
	//driver.findElement(By.id("container_tasks")).click();
	
}
}
