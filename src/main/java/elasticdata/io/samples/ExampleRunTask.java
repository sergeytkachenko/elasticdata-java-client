package elasticdata.io.samples;

import elasticdata.io.EsDataClient;
import elasticdata.io.RunTaskDtoBuilder;
import elasticdata.io.dto.RunTaskDto;
import elasticdata.io.dto.TaskDto;
import elasticdata.io.exception.TaskException;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;

public class ExampleRunTask {

    public static void main(String[] args) {
        EsDataClient esDataClient = new EsDataClient("publicKey", "secretKey");
        try {
            String pipelineId = "5dac67c0e3e69c0001489c1f";
            RunTaskDto runTaskDto = getRunTaskDto();
            TaskDto taskDto = esDataClient.runTask(pipelineId, runTaskDto);
            System.out.println("task run successful, hookUrl = " + taskDto.hookUrl);
            System.out.println("id = " + taskDto.id);
            System.out.println("status: " + taskDto.status);
        } catch (TaskException e) {
            System.out.println("task run fail, more error description in TaskException");
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
