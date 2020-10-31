package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinitons {

    CreateCarPage createCarPage = new CreateCarPage();

    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
       createCarPage.clickOnCreateCar();
    }

    /**
     *   When user adds new vehicle information
     *     | License Plate | SDET |
     *     | Model Year | 2021 |
     *        key        value
     *     Map is a data structure where every value is referenced by key
     *     in ArrayList is always index
     *     dataTable []= {License Plate = SDET , Model Year = 2021};
     *
     *     dataTable is cucumber data structure/data type.Convert into Map , List, List<Map>>
     */
    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String,String> dataTable) {
        //to get all keys and values one by one
        dataTable.forEach((k, v) -> System.out.println("Key: " + k + ", value: " + v));

        System.out.println("License plate: "+ dataTable.get("License Plate"));
        System.out.println("Model year: "+ dataTable.get("Model Year"));

        createCarPage.enterLicencePlate(dataTable.get("License Plate"));
        createCarPage.enterModelYear(dataTable.get("Model Year"));
    }


}
