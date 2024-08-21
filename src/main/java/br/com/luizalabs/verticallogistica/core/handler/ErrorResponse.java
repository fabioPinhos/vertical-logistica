package br.com.luizalabs.verticallogistica.core.handler;

import br.com.luizalabs.verticallogistica.core.domain.dto.ExceptionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String createdAt;
    private int statusCode;
    private String statusDescription;
    private String message;
    private List<ExceptionDto> errors;
    private Object trace;

    public ErrorResponse(HttpStatus status, List<ExceptionDto> errors, String trace) {
        this.statusCode = status.value();
        this.statusDescription = status.getReasonPhrase();
        this.errors = errors;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.message = errors.size() == 1 ? errors.get(0).getMensagem() : "Details errors";
        this.trace = trace;
    }

    public ErrorResponse(HttpStatus status, String message, String trace) {
        final ExceptionDto errorData = ExceptionDto.builder().mensagem(message).build();
        this.statusCode = status.value();
        this.statusDescription = status.getReasonPhrase();
        this.errors = Collections.unmodifiableList(Arrays.asList(errorData));
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.message = message;
        this.trace = trace;
    }
}
