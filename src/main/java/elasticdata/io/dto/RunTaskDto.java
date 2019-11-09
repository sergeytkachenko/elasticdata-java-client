package elasticdata.io.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.JsonPatch;
import java.util.HashMap;
import java.util.List;

public class RunTaskDto {
    public String hookUrl;
    public List<HashMap<String, Object>> jsonCommandsPatch;

    public RunTaskDto(String hookUrl, List<HashMap<String, Object>> patch) {
        this.hookUrl = hookUrl;
        this.jsonCommandsPatch = patch;
    }

    public RunTaskDto(List<HashMap<String, Object>> patch) {
        this.jsonCommandsPatch = patch;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
