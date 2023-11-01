package webUi.pages;

import webUi.controls.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button registerButton = new Button(By.xpath("//img[@src=\"/Images/design/pagesignup.png\"]"));
    public Button loginButton = new Button(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));

}
