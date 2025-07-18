Used Tools and frameworks : Appium/TestNG/Selenium/Maven/Android Studio/Eclipse Test Cases and test scenarios : Attched to the mail as Excel I have used the POM model to impliment that framewrok. Page Objects: Each screen (or significant component) of the app will have its own Java class. This class will contain the locators for the UI elements on that screen and the methods that perform actions on them (e.g., clickSubmitButton(), enterNICNumber()).

Test Classes: Separate classes will contain the actual test logic. These tests will use the methods from the Page Object classes to drive the application and TestNG's Assert to verify the outcomes.

Base Test: A base class will handle the common setup and teardown logic, such as initializing the Appium driver before each test and quitting it afterward.

Test Data: Test images (valid NIC, blurry NIC, valid selfie, etc.) will be stored in the project's resources and pushed to the device/emulator before the test runs.
