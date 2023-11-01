package webUi.respuesta;

import webUi.pages.*;
import webUi.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RespuestaPreguntaTresTestWebUI {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    RegisterSection registerSection =  new RegisterSection();
    SettingsSection settingsSection = new SettingsSection();
    LoginSection loginSection = new LoginSection();


    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }
    String fullName = "Samuel Escobar Bejarano";
    String email = "samueb8@gmail.com";
    String password = "1234";

    @Test
    public void preguntaTres(){
        //Registrar
        registrar(fullName, email, password);

        //Desloguear
        menuSection.logoutButton.click();
        //Volver a intentar registrar
        registrar(fullName, email, password);
        Assertions.assertFalse(menuSection.logoutButton.isControlDisplayed(),
                "ERROR se pudo crear de nuevo la cuenta");
    }

    @Test
    public void eliminarCuenta() throws InterruptedException {
        //Login
        login(email, password);
        //Eliminar
        menuSection.settingsButton.click();
        settingsSection.accountButton.click();
        settingsSection.deleteButton.click();
        Session.getInstance().getAlert().accept();
        Thread.sleep(2000);
        Assertions.assertTrue(mainPage.registerButton.isControlDisplayed(),
                "ERROR no se pudo borrar la cuenta creada");
    }

    private void login(String email, String password){
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(password);
        loginSection.loginButton.click();
    }

    private void registrar(String fullName, String email, String password){
        mainPage.registerButton.click();
        registerSection.fullNameTextBox.clearSetText(fullName);
        registerSection.emailTextBox.setText(email);
        registerSection.passwordTextBox.setText(password);
        registerSection.termsButton.click();
        registerSection.signupButton.click();
    }
}
