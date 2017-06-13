package integration.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wiremock.org.apache.http.HttpResponse;
import wiremock.org.apache.http.client.methods.HttpGet;
import wiremock.org.apache.http.impl.client.CloseableHttpClient;
import wiremock.org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static wiremock.org.hamcrest.CoreMatchers.containsString;
import static wiremock.org.hamcrest.MatcherAssert.assertThat;

public class InventorySteps {

    private static final String APPLICATION_JSON = "application/json";

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    private String result = "";

    @When("^I ask for the products")
    public void i_ask_for_the_basket() throws Throwable {

        HttpGet request = new HttpGet("http://localhost:9000/basket/basket");
        request.addHeader("accept", APPLICATION_JSON);
        HttpResponse httpResponse = httpClient.execute(request);
        result = convertResponseToString(httpResponse);
    }

    @Then("^(?:I get|the user gets) a '(.*)' results$")
    public void I_get_a__response(final String numberOfResults) throws Throwable {

        assertThat(result, containsString("Wooden chair"));
        assertThat(result, containsString("Suede poof"));
    }

    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }
}
