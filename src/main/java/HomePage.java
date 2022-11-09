import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage {


    protected static WebDriver driver;

    //below method to use click function
    public void clickWebElement(By by) {

        driver.findElement(by).click();
    }

    //below method is for sendkeys function with String argument to pass the text
    public void sendText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    //below method is to capture the text using get text getting String as return
    public String captureText(By by) {

        return driver.findElement(by).getText();

    }


    @Test //TestNG keywords for method to run
    public void basePage() {
        //timestamp was created to capture current data time format in order to create unique id

        String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
        clickWebElement(By.className("ico-register")); //use of click method as created above

        sendText(By.id("FirstName"), "Rajesh");  // use of sendKeys method with argument as text as created above

        sendText(By.id("LastName"), "Rathod"); // use of sendKeys method with argument as text as created above


        //declaration of the object of the select method
        Select selectDay = new Select(driver.findElement(By.xpath("//div/select[@name=\"DateOfBirthDay\"]")));
        selectDay.selectByValue("27");

        //declaration of the object of the select method
        Select selectMonth = new Select(driver.findElement(By.xpath("//div/select[@name=\"DateOfBirthMonth\"]")));
        selectMonth.selectByVisibleText("May");

        //declaration of the object of the select method
        Select selectYear = new Select(driver.findElement(By.xpath("//div/select[@name=\"DateOfBirthYear\"]")));
        selectYear.selectByVisibleText("1990");


        // use of sendKeys method with argument as text as created above with timestampe contcated to crated unique id

        sendText(By.id("Email"), "Rejesh.Rathod" + timeStamp + "@gmail.com");

        sendText(By.id("Password"), "Rajesh123456");  // use of sendKeys method with argument as text as created above
        sendText(By.id("ConfirmPassword"), "Rajesh123456"); // use of sendKeys method with argument as text as created above
        clickWebElement(By.id("register-button")); //use of click method as created above

        //used of getText method to capture the text and storing into the variable
        String msg = captureText(By.className("result"));

        //printing the message store in the variable above
        System.out.println(msg);

    }
        @Test //TestNG keywords for method to run
        public void emailAFriend(){
        String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());

        //click method used as declared above along with xpath to find the element
        clickWebElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[2]/div/div/a[1]"));
        //click method used as declared above along with xpath to find the element
        clickWebElement(By.xpath("//div[@class=\"overview-buttons\"]/div[3]/button[@class=\"button-2 email-a-friend-button\"]"));
            // use of sendKeys method with argument as text as created above
        sendText(By.id("FriendEmail"), "rocket"+timeStamp+"@pocket.com");
            // use of sendKeys method with argument as text as created above
        sendText(By.id("YourEmailAddress"), "pocket"+timeStamp+"@rocket.com");
            // use of sendKeys method with argument as text as created above
        sendText(By.id("PersonalMessage"), "This is a fantastic laptop, I would recommend it" );
            //use of click method as created above
        clickWebElement(By.name("send-email"));  //use of click method as created above

            //capturing message into the variable. xpath was used to find the element and getText method to capture the message
        String message = captureText(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li[1]"));

        //printing the captured message
        System.out.println(message);

}
    @Test //TestNG keywords for method to run
    public void homePage(){

        //below, multiple variables are used to capture heading of the different weblinks
        // I have used linktext and partial linktext to find the elements
        String catComputers= captureText(By.linkText("Computers"));
        String catElectronics = captureText(By.linkText("Electronics"));
        String catApparel = captureText(By.linkText("Apparel"));
        String catDigitalDownload = captureText(By.partialLinkText("Digital"));
        String catBooks = captureText(By.linkText("Books"));
        String catJewlry = captureText(By.linkText("Jewelry"));
        String catGiftCards = captureText(By.linkText("Gift Cards"));

        //printing the value stored in above variables with use of concatenation
        System.out.println(catComputers + " " + catElectronics + " " + catApparel + " " + catDigitalDownload + " " + catBooks + " " + catJewlry + " " + catGiftCards);
    }

    @Test //TestNG keywords for method to run
    public void newsComments(){

        //use of click method as created above
        clickWebElement(By.partialLinkText("release"));

        // use of sendKeys method with argument as text as created above
        sendText(By.id("AddNewComment_CommentTitle"),"Joe Bloggs");
        // use of sendKeys method with argument as text as created above
        sendText(By.id("AddNewComment_CommentText"),"This is a demo website for test engineers" );
        //use of click method as created above
        clickWebElement(By.name("add-comment"));

        //capturing message into the variable. xpath was used to find the element and getText method to capture the message
        String commentmessage = captureText(By.xpath("//div[@class=\"result\"]"));

        //printing the value stored in the variable commentmessage
        System.out.println(commentmessage);

    }

    @Test //TestNG keywords for method to run
    public void products(){

        //use of click method as created above
        clickWebElement(By.linkText("Computers"));
        //use of click method as created above
        clickWebElement(By.linkText("Desktops"));

        //capturing title and storing into the variable using getText method declared above
        String title1 = captureText(By.partialLinkText("Build"));
        System.out.println(title1); //printing to stored value

        //capturing title and storing into the variable using getText method declared above
        String title2 = captureText(By.partialLinkText("Digital"));
        System.out.println(title2); //printing to stored value

        //capturing title and storing into the variable using getText method declared above
        String title3 = captureText(By.partialLinkText("Lenovo"));
        System.out.println(title3); //printing to stored value
    }

    @BeforeMethod //This is testNG keyword BeforeMethod. it mean it will run this method everytime before each method
    //this is useful for function like below, to open the browser, maximise the window and go to given URL
    public void openBrowser(){

        //to open chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        //maximise window
        driver.manage().window().maximize();

        //to go to given URL as below
        driver.get("https://demo.nopcommerce.com/");

    }

    @AfterMethod // this is testNG key work which will help to run the method evertime after each method is run


    public void closeBrowser()
    {
    driver.quit();  // to close the browser

    }








}
