package elasticdata.io.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;

public class RunTaskDto {
    public String hookUrl;
    public List<HashMap<String, Object>> jsonCommandsPatch;
    public Boolean withoutDependencies;

    public RunTaskDto(String hookUrl, List<HashMap<String, Object>> patch, Boolean withoutDependencies) {
        this.hookUrl = hookUrl;
        this.jsonCommandsPatch = patch;
        this.withoutDependencies = withoutDependencies;
    }

    public RunTaskDto(List<HashMap<String, Object>> patch) {
        this.jsonCommandsPatch = patch;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
