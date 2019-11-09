package elasticdata.io.dto;

import java.util.Date;

public class TaskDto {
    public String id;
    public String pipelineId;
    public String userId;
    public Date startOnUtc;
    public Date endOnUtc;
    public String status;
    public String failureReason;
    public String hookUrl;
    public String commands;
    public String docsUrl;
}
