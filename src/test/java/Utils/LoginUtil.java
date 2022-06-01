package Utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUtil {

    public String homePageTitle = "Projects";
    public String emailValidationMessage1 = "Please include an '@' in the email address.";
    public String emailValidationMessage2 = "Please enter a part following '@'.";
    public String emailValidationMessage3 = "Please fill out this field.";
    public String userName = System.getenv("GuideCxUserName");
    public String password = System.getenv("GuideCxPassword");
    public String loginUrl = "https://app.staging.guidecx.io/auth/login";
}
