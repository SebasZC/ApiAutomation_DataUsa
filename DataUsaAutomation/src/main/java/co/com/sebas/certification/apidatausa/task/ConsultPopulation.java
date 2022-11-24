package co.com.sebas.certification.apidatausa.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.sebas.certification.apidatausa.utils.Constants.PATH;

public class ConsultPopulation implements Task {

    private String population;

    public ConsultPopulation(String population) {
        this.population = population;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(PATH).with(requestSpecification -> requestSpecification
                .param("Population", this.population)));
    }

    public static ConsultPopulation consultPopulation(String population){
        return Tasks.instrumented(ConsultPopulation.class, population);
    }
}
