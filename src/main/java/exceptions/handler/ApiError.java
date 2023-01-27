package exceptions.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiError {
    private LocalDateTime timeStamp;
    private String status;
    private String message;
    private String path;

    public ApiError(LocalDateTime timeStamp) {
        this.timeStamp = LocalDateTime.now();
    }
    @Builder
    public ApiError(HttpServletRequest request) {
        this.path = request.getContextPath();
    }
}
