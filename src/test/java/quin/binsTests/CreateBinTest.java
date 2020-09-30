package quin.binsTests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import quin.service.CreateBinsService;
import quin.utils.BinsUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static quin.data.BinData.EXAMPLE_BODY;
import static quin.data.BinData.LONGER_NAME_MESSAGE;
import static quin.data.BinData.LONG_NAME;
import static quin.data.BinData.NAME;
import static org.hamcrest.core.IsEqual.equalTo;
import org.json.simple.JSONObject;
import responses.BinResponse;
import responses.ErrorRequestResponse;

import java.io.IOException;

public class CreateBinTest {

    private CreateBinsService createBinsService = new CreateBinsService();
    private BinsUtils binsUtils = new BinsUtils();
    private JSONObject body;

    @Test
    public void canCreateBin() throws IOException, ParseException {
        body = binsUtils.convertJsonFileToJsonObject(EXAMPLE_BODY);
        BinResponse binResponse = createBinsService.createBin(body);
        BinsUtils.fillBins(binResponse.getId());

        assertThat(binResponse.getSuccess(), equalTo(true));
        assertThat(binResponse.getData().get("sample"), equalTo("Hello World"));
    }

    @Test
    public void canCreateAPublicBinWithName() throws IOException, ParseException {
        body = binsUtils.convertJsonFileToJsonObject(EXAMPLE_BODY);
        BinResponse binResponse = createBinsService.createPublicBinWithName(body, NAME);
        binsUtils.fillBins(binResponse.getId());

        assertThat(binResponse.getSuccess(), equalTo(true));
        assertThat(binResponse.getData().get("sample"), equalTo("Hello World"));
        assertThat(binResponse.getPrivateStatus(), equalTo(false));
    }

    @Test
    public void cannotCreateBinWithLongerName() throws IOException, ParseException {
        body = binsUtils.convertJsonFileToJsonObject(EXAMPLE_BODY);
        ErrorRequestResponse binResponse = createBinsService.createPublicBinWithNameErrorRequest(body,LONG_NAME);

        assertThat(binResponse.getSuccess(), equalTo(false));
        assertThat(binResponse.getMessage(), equalTo(LONGER_NAME_MESSAGE));
    }
}
