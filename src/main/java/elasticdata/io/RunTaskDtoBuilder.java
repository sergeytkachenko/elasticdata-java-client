package elasticdata.io;

import elasticdata.io.dto.RunTaskDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RunTaskDtoBuilder {
    private String hookUrl;
    private List<HashMap<String, Object>> patch;

    public RunTaskDtoBuilder() {
        this.patch = new ArrayList<>();
    }

    public RunTaskDtoBuilder setHookUrl(String hookUrl) {
        this.hookUrl = hookUrl;
        return this;
    }

    public RunTaskDtoBuilder addCommandPatch(HashMap<String, Object> commandPatch) {
        patch.add(commandPatch);
        return this;
    }

    public RunTaskDto build() {
        if (hookUrl == null) {
            return new RunTaskDto(patch);
        }
        return new RunTaskDto(hookUrl, patch);
    }
}
