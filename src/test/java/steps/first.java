package steps;

import cucumber.api.java8.En;


import org.junit.Assert;
import util.ApiStep;


public class first implements En {
    private ApiStep step = new ApiStep();

    public first () {
        Given("user access url {string}", (String url) -> {
           step.setURL(url);
        } );

        When("user send POST|GET|PUT|DELETE request to url", (String url) -> {

        } );

        When("user grab url with id {int}", (Integer id) -> {
            step.getURLRequestWithID(id);
        } );

        And("verify status code is {int}", (Integer code) -> {
            step.verifyStatusCode(code);
            step.showResponse();
        } );

        And("verify the JSON response should have {string} with {string}", (String obj, String value) -> {
            step.verifyDataResponse(obj, value);
        });

    }
}
