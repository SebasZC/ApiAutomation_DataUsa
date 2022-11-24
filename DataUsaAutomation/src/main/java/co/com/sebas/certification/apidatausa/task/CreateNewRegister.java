package co.com.sebas.certification.apidatausa.task;

import co.com.sebas.certification.apidatausa.utils.ReadFile;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static co.com.sebas.certification.apidatausa.utils.Constants.PATH;
import static co.com.sebas.certification.apidatausa.utils.JsonRoutes.API_MANAGEMENT_JSON;

public class CreateNewRegister implements Task {

    private List<String> dataRegister;

    public CreateNewRegister(List<String> dataRegister) {
        this.dataRegister = dataRegister;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String bodyCreate = String.format(ReadFile.returnFile(API_MANAGEMENT_JSON),
                dataRegister.get(0),
                dataRegister.get(1),
                dataRegister.get(2),
                dataRegister.get(3),
                dataRegister.get(4),
                dataRegister.get(5));
        actor.attemptsTo(Post.to(PATH).with(requestSpecification -> requestSpecification
                .body(bodyCreate)));
    }

    public static CreateNewRegister createNewRegister(List<String> dataRegister){
        return Tasks.instrumented(CreateNewRegister.class, dataRegister);
    }
}
