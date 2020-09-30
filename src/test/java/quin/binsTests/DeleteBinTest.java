package quin.binsTests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import quin.service.DeleteBinsService;
import responses.BinResponse;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static quin.data.BinData.BIN_ID;
import static quin.data.BinData.INVALID_BIN_ID;
import static quin.data.BinData.INVALID_BIN_ID_MESSAGE;
import static quin.data.BinData.SUCCESS_DELETE_MESSAGE;


public class DeleteBinTest {

    private DeleteBinsService deleteBinsService = new DeleteBinsService();

    @Test
    public void canDeleteABin() throws IOException, ParseException {
        BinResponse binResponse = deleteBinsService.deleteBin(BIN_ID);

        assertThat(binResponse.getSuccess(), equalTo(true));
        assertThat(binResponse.getMessage(), containsString(SUCCESS_DELETE_MESSAGE));
    }

    // It's trowing a different message ("Invalid Record ID") and "success" parameter is null
    @Test
    public void cannotReadASpecificBin() throws IOException, ParseException {
        ErrorRequestResponse binReadResponse = deleteBinsService.deleteBinErrorRequestResponse(INVALID_BIN_ID);

        assertThat(binReadResponse.getSuccess(), equalTo(false));
        assertThat(binReadResponse.getMessage(), equalTo(INVALID_BIN_ID_MESSAGE));
    }
}
