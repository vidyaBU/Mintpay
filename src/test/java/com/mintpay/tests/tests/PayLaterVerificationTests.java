package com.mintpay.tests.tests;
import com.mintpay.tests.base.BaseTest;
import com.mintpay.tests.pages.PayLaterVerificationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PayLaterVerificationTests extends BaseTest{

	 @Test(description = "TC-001: Successful verification with a valid NIC.")
	    public void testSuccessfulVerificationWithNIC() {
	        
	        String validNicPath = "/sdcard/testdata/valid_nic.jpg";
	        String validSelfiePath = "/sdcard/testdata/valid_selfie.jpg";
	        
	        
	        
	        PayLaterVerificationPage verificationPage = new PayLaterVerificationPage(driver);

	
	        verificationPage.selectNICType();
	        verificationPage.uploadDocument(validNicPath);
	        verificationPage.captureSelfie(validSelfiePath);
	        verificationPage.clickSubmit();

	
	        Assert.assertTrue(verificationPage.isVerificationSuccessful(), "Verification success screen was not displayed.");
	    }

	    @Test(description = "TC-008: Attempt to submit without uploading a document.")
	    public void testSubmitWithoutDocument() {
	        PayLaterVerificationPage verificationPage = new PayLaterVerificationPage(driver);
	        
	       
	        verificationPage.selectNICType();
	       
	        verificationPage.captureSelfie("/sdcard/testdata/valid_selfie.jpg");

	 
	        verificationPage.clickSubmit();
	        
	 
	        String expectedError = "Please upload your document.";
	        String actualError = verificationPage.getErrorMessage();
	        Assert.assertEquals(actualError, expectedError, "The error message for missing document is incorrect.");
	    }
	    
	    @Test(description = "TC-003: Attempt verification with a blurry/unreadable document.")
	    public void testSubmitWithBlurryDocument() {
	  
	        String blurryNicPath = "/sdcard/testdata/blurry_nic.jpg";
	        PayLaterVerificationPage verificationPage = new PayLaterVerificationPage(driver);
	        
	      
	        verificationPage.selectNICType();
	        verificationPage.uploadDocument(blurryNicPath);
	        verificationPage.captureSelfie("/sdcard/testdata/valid_selfie.jpg");
	        verificationPage.clickSubmit();
	        
	
	        String expectedError = "Document is unreadable. Please upload a clear image.";
	        String actualError = verificationPage.getErrorMessage();
	        Assert.assertEquals(actualError, expectedError, "The Document is incorrect");
	    }

	
}
