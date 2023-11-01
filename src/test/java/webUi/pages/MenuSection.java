package webUi.pages;

import webUi.controls.Button;
import org.openqa.selenium.By;

public class MenuSection {
    public Button settingsButton = new Button(By.xpath("//a[@href='javascript:OpenSettingsDialog();']"));
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));

}
