package com.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPages {
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Contact']")
	WebElement ContactButton;
	public WebElement getContactButton() {
		return ContactButton;
	}

	@FindBy(id = "g3-name")
	WebElement Name;
	public WebElement getName() {
		return Name;
	}

	@FindBy(id = "g3-email")
	WebElement Email;
	public WebElement getEmail() {
		return Email;
	}
	@FindBy(xpath = "//textarea[contains(@id,'message')]")
	WebElement message;
	public WebElement getMessage() {
		return message;
	}

	@FindBy(css = ".wp-block-button__link.has-text-color.has-black-color")
	WebElement ContactMe;
	public WebElement getContactMe() {
		return ContactMe;
	}
	@FindBy(css = "#contact-form-success-header")
	WebElement SentMessage;
	public WebElement getSentMessage() {
		return SentMessage;
	}
	public AutomationPages(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);

	}
}


