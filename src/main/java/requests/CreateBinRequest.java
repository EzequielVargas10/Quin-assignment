package requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@JsonPropertyOrder({"sample"})
public class CreateBinRequest {

    @JsonProperty("sample")
    @Valid
    @NotNull
    private String sample;

    @JsonProperty("sample")
    public String getSample() {
        return this.sample;
    }
}
