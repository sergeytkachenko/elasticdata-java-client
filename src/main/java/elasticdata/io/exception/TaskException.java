package elasticdata.io.exception;

import elasticdata.io.dto.ErrorMessageDto;

public class TaskException extends Exception {
    public TaskException(Exception e) {
        super(e);
    }
    public TaskException(ErrorMessageDto castToErrorMessageDto) {
        super(new Exception(castToErrorMessageDto.error + ", " + castToErrorMessageDto.message));
    }
}
