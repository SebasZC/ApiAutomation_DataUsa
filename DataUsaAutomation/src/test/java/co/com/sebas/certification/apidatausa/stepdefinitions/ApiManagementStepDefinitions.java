package co.com.sebas.certification.apidatausa.stepdefinitions;

import co.com.sebas.certification.apidatausa.questions.ShouldStatusCode;
import co.com.sebas.certification.apidatausa.questions.ValidateFields;
import co.com.sebas.certification.apidatausa.questions.ShouldDisplayObject;
import co.com.sebas.certification.apidatausa.questions.ValidateYear;
import co.com.sebas.certification.apidatausa.task.ConsultPopulation;
import co.com.sebas.certification.apidatausa.task.ConsultYear;
import co.com.sebas.certification.apidatausa.task.CreateNewRegister;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;

import static co.com.sebas.certification.apidatausa.utils.Constants.END_POINT;

public class ApiManagementStepDefinitions {

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(END_POINT)));
        OnStage.theActorCalled("User");
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @When("^the user consult the information by (.*)$")
    public void theUserConsultTheInformationByYear(String year){
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultYear.consultYear(year));
    }

    @Then("^the user should watch (.*)$")
    public void theUserShouldWatch(String population) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateYear.validateYear(), Matchers.equalTo(population)));
    }

    @Then("the user going to watch the correct information")
    public void theUserGoingToWatchTheCorrectInformation() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateFields.validateFields(), Matchers.is(false)));
    }

    @When("^the user consult the population (.*)$")
    public void theUserConsultThePopulation(String population) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultPopulation.consultPopulation(population));
    }

    @Then("^display field (.*) and value (.*) in service response$")
    public void displayFieldDataYearAndValueYearInServiceResponse(String key, String value) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ShouldDisplayObject.returnObject(key, value)));
    }

    @When("the user send the information")
    public void theUserSendTheInformation(List<String> dataRegister) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateNewRegister.createNewRegister(dataRegister));
    }

    @Then("^should display the response with code (.*)$")
    public void shouldDisplayTheResponseWithCode(int statusCode) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ShouldStatusCode.statusCode(),Matchers.equalTo(statusCode)));
    }
}
