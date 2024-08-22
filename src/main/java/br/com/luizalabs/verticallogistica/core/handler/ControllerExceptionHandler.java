package br.com.luizalabs.verticallogistica.core.handler;

import br.com.luizalabs.verticallogistica.core.exception.*;
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
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, "Erro ao fechar arquivo", null);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ArquivoVazioException.class)
    public ErrorResponse handleArquivoVazio(final ArquivoVazioException e){
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, "Arquivo esta vazio", null);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUsuarioNaoExisteException(final UserNotFoundException e){
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Usuario informado não existe", null);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(OrderNotFoundException.class)
    public ErrorResponse handleOrderNaoExisteException(final OrderNotFoundException e){
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Order informado não existe", null);
    }

}
