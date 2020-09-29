package quin.service;

import io.restassured.response.ValidatableResponse;
import org.json.simple.parser.ParseException;
import quin.client.CreateBinRestClient;
import requests.CreateBinRequest;
import responses.CreateBinResponse;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

public class CreateBinsService{

    private CreateBinRestClient createBinsRestClient = new CreateBinRestClient();

    public CreateBinResponse createBin(Object body) throws IOException, ParseException {
        return createBinAndExpectStatus(body, SC_OK)
                .extract()
                .as(CreateBinResponse.class);
    }

    public ErrorRequestResponse createBinErrorResponse(CreateBinRequest createBinRequest) throws IOException, ParseException {
        return createBinAndExpectStatus(createBinRequest, SC_BAD_REQUEST)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public ErrorRequestResponse createBinUnauthorized(Object body) throws IOException, ParseException {
        return createBinAndExpectStatus(body, SC_UNAUTHORIZED)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public ErrorRequestResponse createBinWithoutApiKey(Object body) throws IOException, ParseException {
        return createBinsRestClient.createBinWithoutApiKey(body)
                .then()
                .statusCode(SC_UNAUTHORIZED)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public CreateBinResponse createPublicBinWithName(Object body) throws IOException, ParseException {
        return createBinsRestClient.createPublicBinWithName(body)
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(CreateBinResponse.class);
    }

    public ValidatableResponse createBinAndExpectStatus(Object body,
                                                        int httpStatus) throws IOException, ParseException {
        return createBinsRestClient
                .createBin(body)
                .then()
                .statusCode(httpStatus);
    }
}
