package elasticdata.io.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.JsonPatch;
import java.util.List;

public class RunTaskDto {
    public String hookUrl;
    public List<JsonPatch> jsonCommandsPatch;

    public RunTaskDto(String hookUrl, List<JsonPatch> jsonCommandsPatch) {
        this.hookUrl = hookUrl;
        this.jsonCommandsPatch = jsonCommandsPatch;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
