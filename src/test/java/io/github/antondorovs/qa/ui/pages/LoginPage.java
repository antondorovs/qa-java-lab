package io.github.antondorovs.qa.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement username = $("[data-test='username']");
    private final SelenideElement password = $("[data-test='password']");
    private final SelenideElement loginButton = $("[data-test='login-button']");
    private final SelenideElement error = $("[data-test='error']");

    public LoginPage openPage() {
        open("/");
        loginButton.shouldBe(visible);
        return this;
    }

    public void loginAs(String user, String pass) {
        username.setValue(user);
        password.setValue(pass);
        loginButton.click();
    }

    public InventoryPage loginAsStandardUser() {
        loginAs("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage();
        inventory.shouldBeOpen();
        return inventory;
    }

    public void shouldShowError(String message) {
        error.shouldBe(visible).shouldHave(exactText(message));
        loginButton.shouldBe(visible);
    }
}
