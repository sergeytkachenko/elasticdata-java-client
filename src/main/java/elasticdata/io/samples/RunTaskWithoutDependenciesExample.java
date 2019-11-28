package elasticdata.io.samples;

import elasticdata.io.EsDataClient;
import elasticdata.io.RunTaskDtoBuilder;
import elasticdata.io.dto.RunTaskDto;
import elasticdata.io.dto.TaskDto;
import elasticdata.io.exception.TaskException;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;

public class RunTaskWithoutDependenciesExample {

    public static void main(String[] args) {
        EsDataClient esDataClient = new EsDataClient("publicKey", "secretKey");
        try {
            String pipelineId = "5ddbc6396e87cc7286981266";
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
                .withoutDependencies()
                .build();
    }
}
