import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;


public class CharacterSteps {

    private static RequestSpecification request;
    private Response response;
    private String characterEndpoint = "people/";
    private int validRandomNum;
    private int invalidRandomNum;

    @Given("^have a valid Star Wars Character$")
    public int haveAValidStarWarsCharacter() {

        int validRandomNum = (int) ((Math.random()*80)+1);

        return validRandomNum;
    }

    @When("^send a GET request to (.+) URI with 11 ID valid$")
    public void sendAValidCharacterGETRequest(String URI) {
        request = given()
                .baseUri(URI+characterEndpoint+11)
                .contentType(ContentType.JSON)
                .log().all();

        response = request.when().get().prettyPeek();

    }

    @Then("result should be status code {int}")
    public void resultShouldBeStatusCode(int expectedStatusCode) {

        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match expected value");
    }

//    @Given("^have an invalid Star Wars Character$")
//    public int haveAnInvalidStarWarsCharacter() {
//        int invalidRandomNum = 0;
//
//        return invalidRandomNum;
//    }
//
//    @When("send a GET request to (.+) URI with ([1-9]\\d*) ID invalid")
//    public void sendAGETRequestToHttpsSwapiDevApiURIWithIDInvalid(String URI, int invalidRandomNum) {
//        request = given()
//                .baseUri(URI + characterEndpoint + invalidRandomNum)
//                .contentType(ContentType.JSON)
//                .log().all();
//
//        response = request.when().get().prettyPeek();
//
//        String actualResponse = response.toString();
//
//        return actualResponse;
//    }
}
