import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.proxy;

public class CharacterSteps {

    private static RequestSpecification request;
    private Response response;
    private static String characterEndpoint = "people/";
    private int validRandomNum = (int) ((Math.random()*80)+1);
    private int invalidRandomNum = (int) ((Math.random() * (500 - 100)) + 90);

    @Given("^have a valid Star Wars Character$")
    public void haveAValidStarWarsCharacter() {

    }

    @When("^send a GET request to (.+) URI$")
    public String sendACharacterGETRequest(String URI) {

        request = given()
                .baseUri(URI+characterEndpoint+ validRandomNum)
                .contentType(ContentType.JSON)
                .log().all();

        response = request.when().get().prettyPeek();

       return response.toString();
    }

    @Then("result should be status code {int}")
    public void resultShouldBeStatusCode(int expectedStatusCode) {

//        Assert.fail();

    }

    @Given("have an invalid Star Wars Character")
    public void haveAnInvalidStarWarsCharacter() {

    }
}
