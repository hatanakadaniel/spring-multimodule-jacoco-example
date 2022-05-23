package com.hatanaka.springmultimodulejacocoexample.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class StepDefinition {

    @Given("uma request")
    public void umaRequest() {
    }

    @When("chamar um {string} para {string}")
    public void chamarUmPara(String method, String path) {

    }

    @Then("deve retornar {int}")
    public void deveRetornar(int httpStatus) {
        Assertions.assertThat(httpStatus).isEqualTo(200);
    }
}
