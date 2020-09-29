package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@JsonPropertyOrder({"message", "success"})
public class ErrorRequestResponse {

    @JsonProperty("message")
    @Valid
    @NotNull
    private String message;

    @JsonProperty("success")
    @Valid
    @NotNull
    private Boolean success;

    @JsonProperty("message")
    public String getMessage() {
        return this.message;
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return this.success;
    }
}
