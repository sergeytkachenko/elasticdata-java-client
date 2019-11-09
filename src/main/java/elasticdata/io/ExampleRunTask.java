package elasticdata.io;

import elasticdata.io.dto.RunTaskDto;
import elasticdata.io.dto.TaskDto;
import elasticdata.io.exception.RunTaskException;
import org.jetbrains.annotations.NotNull;

import javax.json.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExampleRunTask {

    public static void main(String[] args) {
        EsDataClient esDataClient = new EsDataClient("https://app.elasticdata.io/api", "publicKey", "secretKey");
        try {
            String pipelineId = "5dac67c0e3e69c0001489c1f";
            RunTaskDto runTaskDto = getRunTaskDto();
            TaskDto taskDto = esDataClient.runTask(pipelineId, runTaskDto);
            System.out.println("task run successful, hookUrl = " + taskDto.hookUrl);
            System.out.println("id = " + taskDto.id);
            System.out.println("status: " + taskDto.status);
        } catch (RunTaskException e) {
            System.out.println("task run fail, more error description in RunTaskException");
            System.out.println(e);
        }
    }

    @NotNull
    private static RunTaskDto getRunTaskDto() {
        RunTaskDtoBuilder runTaskDtoBuilder = new RunTaskDtoBuilder();
        return runTaskDtoBuilder
                .setHookUrl("https://my-site.com.ua/callback/task")
                .addCommandPatch(getUrlPatch())
                .build();
    }

    @NotNull
    private static HashMap<String, Object> getUrlPatch() {
        // create url patch command
        // see details of the path - http://jsonpatch.com/
        HashMap<String, Object> urlPatch = new HashMap<>();
        urlPatch.put("op", "replace");
        urlPatch.put("path", "/commands/0/params/urls");
        urlPatch.put("value", Arrays.asList("https://google.com.ua", "https://yandex.com.ua"));
        return urlPatch;
    }
}
