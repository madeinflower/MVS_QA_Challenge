# MVS_QA_Challenge
Task: The default is a base class "Base", which provides a WebDriver object. How this is initialized is not important. It can easily be retrieved using "getDriver()" and then used.
The task is to use the Base base class and to use the WebDriver object to search for "Active sync" using Selenium in Google. Then the first link should be clicked.
Focus should be on scalability and coding style.

For reference and assistance, the class "Base" may look like this, for example:

public class Base{
protected WebDriver getDriver(){
WebDriver driver = null;
//WebDriver is created here. No need for details.
return driver;
}
}