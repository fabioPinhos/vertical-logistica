package br.com.luizalabs.verticallogistica.application;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileUploadService {

    void readFile(MultipartFile file) throws IOException;

}
