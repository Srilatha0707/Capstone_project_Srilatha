package com.qa.testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Automationpanda_001 extends TestBase{
	@Test(priority = 0)
	public void checkTitle() throws IOException {
	  boolean homepagetitle=driver.getTitle().contains("Automation Panda");
	  if(homepagetitle){
		  Assert.assertTrue(true);
	  }
	  else {
		  captureScreenshot(driver,"checkTitle");
		  Assert.assertTrue(false,"Title shown is Incorrect");
	  }
	}
	@Test(priority = 1)
	public void checkContactButton() throws IOException {
		boolean contactbutton=ap.getContactButton().isEnabled();
		if(contactbutton) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver, "checkContactButton");
			Assert.assertTrue(false,"Contact Button is not enabled");
		}
		ap.getContactButton().click();
		String contacttitle=driver.getTitle();
		Assert.assertEquals(contacttitle,"Contact | Automation Panda","contact page title is incorrect");
	}

	@Test(priority = 2,dependsOnMethods = "checkContactButton")
	public void checkSubmit() throws IOException {
		ap.getName().sendKeys("Srilatha");
		ap.getEmail().sendKeys("sample@gmail.com");
		ap.getMessage().sendKeys("Good");
		if(ap.getContactMe().isEnabled()) {
            Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver,"checkSubmit");
			Assert.assertTrue(false,"submit button is not enabled");
		}
		ap.getContactMe().click();
		String message=ap.getSentMessage().getText();
		if(message.contains("Your message has been sent")) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver, "checkSubmit");
			Assert.assertTrue(false,"message is incorrect");
		}
	}

}

