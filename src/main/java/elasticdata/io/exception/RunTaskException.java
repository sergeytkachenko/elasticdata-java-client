package elasticdata.io.exception;

import elasticdata.io.dto.ErrorMessageDto;

public class RunTaskException extends Exception {
    public RunTaskException(Exception e) {
        super(e);
    }
    public RunTaskException(ErrorMessageDto castToErrorMessageDto) {
        super(new Exception(castToErrorMessageDto.error + ", " + castToErrorMessageDto.message));
    }
}
