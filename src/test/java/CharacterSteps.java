import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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

    @When("^send a GET request to (.+) URI with ID ([1-9]\\d*)$")
    public void sendAValidCharacterGETRequest(String URI, int num) {
        request = given()
                .baseUri(URI+characterEndpoint+num)
                .contentType(ContentType.JSON)
                .log().all();

        response = request.when().get().prettyPeek();

    }

    @Then("result should be status code {int}")
    public void resultShouldBeStatusCode(int expectedStatusCode) {

        int actualStatusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        SoftAssert softAssert = new SoftAssert();


        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match expected 200");
        Assert.assertTrue(responseBody.contains("\"name\":\"Anakin Skywalker\""));

        softAssert.assertAll();

    }
}