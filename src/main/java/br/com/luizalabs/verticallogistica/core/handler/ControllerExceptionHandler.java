package br.com.luizalabs.verticallogistica.core.handler;

import br.com.luizalabs.verticallogistica.core.exception.ArquivoInvalidoException;
import br.com.luizalabs.verticallogistica.core.exception.ErroAoFecharArquivoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ArquivoInvalidoException.class)
    public ErrorResponse handleArquivoInvalido(final ArquivoInvalidoException e){
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, "Erro ao ler arquivo", null);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ErroAoFecharArquivoException.class)
    public ErrorResponse handleFecharArquivo(final ErroAoFecharArquivoException e){
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, "erro ao fechar arquivo", null);
    }

}
