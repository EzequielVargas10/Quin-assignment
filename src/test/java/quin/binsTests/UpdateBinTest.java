package quin.binsTests;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import quin.service.UpdateBinsService;
import quin.utils.BinsUtils;
import responses.BinResponse;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static quin.data.BinData.EXAMPLE_UPDATE_BODY;
import static quin.data.BinData.EMPTY_JSON_MESSAGE;

public class UpdateBinTest {

    private UpdateBinsService updateBinsService = new UpdateBinsService();
    BinsUtils binsUtils = new BinsUtils();
    private JSONObject body;

    @Test
    public void canUpdateABin() throws IOException, ParseException {
        body = binsUtils.convertJsonFileToJsonObject(EXAMPLE_UPDATE_BODY);
        BinResponse binResponse = updateBinsService.updateBin(body,BinsUtils.getBins(0));

        assertThat(binResponse.getSuccess(), equalTo(true));
        assertThat(binResponse.getData().get("sample"), equalTo("Hallo World"));
    }

    @Test
    public void cannotUpdateABin() throws IOException, ParseException {
        JSONObject emptyBody = new JSONObject();
        ErrorRequestResponse binRead = updateBinsService.updateBinErrorRequestResponse(emptyBody,BinsUtils.getBins(0));

        assertThat(binRead.getSuccess(), equalTo(false));
        assertThat(binRead.getMessage(), equalTo(EMPTY_JSON_MESSAGE));
    }
}
