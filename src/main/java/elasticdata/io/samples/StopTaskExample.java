package elasticdata.io.samples;

import elasticdata.io.EsDataClient;
import elasticdata.io.dto.TaskDto;
import elasticdata.io.exception.TaskException;

public class StopTaskExample {

    public static void main(String[] args) {
        EsDataClient esDataClient = new EsDataClient("publicKey", "secretKey");
        try {
            String taskId = "5dc6be9d5b809200017dab11";
            TaskDto taskDto = esDataClient.stopTask(taskId);
            System.out.println("task run successful, hookUrl = " + taskDto.hookUrl);
            System.out.println("id = " + taskDto.id);
            System.out.println("status: " + taskDto.status);
            System.out.println("docsUrl: " + taskDto.docsUrl);
        } catch (TaskException e) {
            System.out.println("get task fail, more error description in TaskException");
            System.out.println(e);
        }
    }
}
