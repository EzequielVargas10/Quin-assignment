package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

@JsonPropertyOrder({"success", "data", "id", "private", "message"})
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class BinResponse {

    @JsonProperty("success")
    @Valid
    @NotNull
    private Boolean success;

    @JsonProperty("data")
    @Valid
    @NotNull
    private HashMap<String, String> data;

    @JsonProperty("id")
    @Valid
    @NotNull
    private String id;

    @JsonProperty("private")
    @Valid
    @NotNull
    private Boolean privateStatus;

    @JsonProperty("message")
    @Valid
    @NotNull
    private String message;


    @JsonProperty("success")
    public Boolean getSuccess() {
        return this.success;
    }

    @JsonProperty("data")
    public HashMap<String, String> getData() {
        return this.data;
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    @JsonProperty("private")
    public Boolean getPrivateStatus() {
        return this.privateStatus;
    }

    @JsonProperty("message")
    public String getMessage() {
        return this.message;
    }
}
