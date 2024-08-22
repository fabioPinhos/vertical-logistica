package br.com.luizalabs.verticallogistica.application.service;

import br.com.luizalabs.verticallogistica.core.domain.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IFileUploadService {

    List<UserDto> readFile(MultipartFile file) throws IOException;

}
