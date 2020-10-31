package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class CreateCarPage extends BasePage{

    @FindBy(css = "[title='Create Car']")
    private WebElement crateCarBtn;


    @FindBy(name = "custom_entity_type[LicensePlate]")
    private WebElement licencePlateInputBox;

    @FindBy(name = "custom_entity_type[ModelYear]")
    private WebElement modelYearInputBox;

    public void clickOnCreateCar() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(crateCarBtn)).click();
        System.out.println("Clicking on 'Create car' button");

    }
    public void enterLicencePlate (String licensePlate){
        BrowserUtils.enterText(licencePlateInputBox,licensePlate);
    }

    public void enterModelYear (String modelYear){
        BrowserUtils.enterText(licencePlateInputBox,modelYear);
    }
}