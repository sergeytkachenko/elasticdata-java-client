package elasticdata.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import elasticdata.io.dto.ErrorMessageDto;
import elasticdata.io.dto.RunTaskDto;
import elasticdata.io.dto.TaskDto;
import elasticdata.io.exception.RunTaskException;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class EsDataClient {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private String endpoint = "https://app.elasticdata.io/api";
    private String key;
    private String secret;

    public EsDataClient(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }

    public TaskDto runTask(String pipelineId, RunTaskDto runTaskDto) throws RunTaskException {
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(runTaskDto.toJson(), JSON);
            Request request = new Request.Builder()
                    .url(this.endpoint + "/pipeline/run/" + pipelineId)
                    .post(body)
                    .build();
            String json = null;
            try (Response response = client.newCall(request).execute()) {
                ResponseBody responseBody = response.body();
                json = Objects.requireNonNull(responseBody).string();
                return this.castToTaskDto(json);
            } catch (Exception e) {
                throw new RunTaskException(this.castToErrorMessageDto(json));
            } finally {
                client.dispatcher().executorService().shutdown();
                client.connectionPool().evictAll();
            }
        } catch (Exception e) {
            throw new RunTaskException(e);
        }
    }
    public TaskDto stopTask(String taskId) {
        return new TaskDto();
    }
    public TaskDto getTask(String taskId) {
        return new TaskDto();
    }
    public List<HashMap<String, Object>> getLastData(String pipelineId) {
        return new ArrayList<>();
    }

    private TaskDto castToTaskDto (String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TaskDto.class);
    }
    private ErrorMessageDto castToErrorMessageDto (String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, ErrorMessageDto.class);
    }
}
