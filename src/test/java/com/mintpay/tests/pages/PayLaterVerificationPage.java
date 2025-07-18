 package com.mintpay.tests.pages;
 import io.appium.java_client.android.AndroidDriver;
 import io.appium.java_client.pagefactory.AndroidFindBy;
 import io.appium.java_client.pagefactory.AppiumFieldDecorator;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.PageFactory;
 
 
public class PayLaterVerificationPage {
	 private AndroidDriver driver;

	   
	    @AndroidFindBy(id = "com.mintpay.app:id/radio_button_nic")
	    private WebElement nicRadioButton;

	    @AndroidFindBy(id = "com.mintpay.app:id/radio_button_license")
	    private WebElement licenseRadioButton;

	    @AndroidFindBy(id = "com.mintpay.app:id/button_upload_document")
	    private WebElement uploadDocumentButton;

	    @AndroidFindBy(id = "com.mintpay.app:id/button_capture_selfie")
	    private WebElement captureSelfieButton;
	    
	    @AndroidFindBy(id = "com.mintpay.app:id/button_submit_verification")
	    private WebElement submitButton;

	    @AndroidFindBy(id = "com.mintpay.app:id/text_error_message")
	    private WebElement errorMessageText;
	    
	    @AndroidFindBy(id = "com.mintpay.app:id/text_success_title")
	    private WebElement successTitle;

	    public PayLaterVerificationPage(AndroidDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }

	 
	    public void selectNICType() {
	        nicRadioButton.click();
	    }

	    public void uploadDocument(String filePathOnDevice) {
	        uploadDocumentButton.click();
	      
	        System.out.println("Uploading file from: " + filePathOnDevice);
	    }

	    public void captureSelfie(String selfiePathOnDevice) {
	        captureSelfieButton.click();
	     
	        System.out.println("Uploading selfie from: " + selfiePathOnDevice);
	    }

	    public void clickSubmit() {
	        submitButton.click();
	    }
	    
	    public String getErrorMessage() {
	        return errorMessageText.getText();
	    }

	    public boolean isVerificationSuccessful() {
	       
	        return successTitle.isDisplayed() && successTitle.getText().contains("Success");
	    }

	
}
