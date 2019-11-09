package elasticdata.io;

import elasticdata.io.dto.RunTaskDto;
import elasticdata.io.dto.TaskDto;
import elasticdata.io.exception.RunTaskException;
import org.jetbrains.annotations.NotNull;

import javax.json.*;
import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        EsDataClient esDataClient = new EsDataClient("https://app.elasticdata.io/api", "publicKey", "secretKey");
        try {
            String pipelineId = "pipelineId";
            RunTaskDto runTaskDto = getRunTaskDto();
            TaskDto taskDto = esDataClient.runTask(pipelineId, runTaskDto);
            System.out.println("id = " + taskDto.id);
            System.out.println("status: " + taskDto.status);
        } catch (RunTaskException e) {
            System.out.println(e);
        }
    }

    @NotNull
    private static RunTaskDto getRunTaskDto() {
        String hookUrl = "https://my-site.com.ua/callback/task";
        List<JsonPatch> jsonCommandsPatch = new ArrayList<>();
//        JsonPatchBuilder builder = Json.createPatchBuilder();
//        JsonValue link = Json.createValue("http://link");
//        JsonArray links = Json.createArrayBuilder().build();
//        links.add(link);
//        JsonPatch patch = builder
//                .replace("/commands/0/params/urls", "http://link")
//                .build();
        return new RunTaskDto(hookUrl, jsonCommandsPatch);
    }
}
