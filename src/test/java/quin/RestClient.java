package quin;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.internal.TestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class RestClient extends Base{

    public static final String APP_BASE_URI = ("https://api.jsonbin.io/");
    public static final String CREATE_BIN = ("https://api.jsonbin.io/b");
    public static final String GET_BIN = CREATE_BIN + "/%s";
    public static final String UPDATE_BIN = CREATE_BIN + "/%s";
    public static final String GET_LATEST_BIN = CREATE_BIN + "/%s/latest";
    public static final String CONTENT_TYPE = ("application/json");

    public RequestSpecification requestSpecification(){

//        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
//        RequestSpecification requestSpecific = requestBuilder.setBaseUri(APP_BASE_URI).setBasePath(APP_BASE_URI) .addQueryParam("format", "json").build();
        RequestSpecification requestSpec = new RequestSpecBuilder().
                setBaseUri(APP_BASE_URI).
                build();
        return requestSpec;
    }

}
