package br.com.luizalabs.verticallogistica.application.impl;

import br.com.luizalabs.verticallogistica.application.IFileUploadService;
import br.com.luizalabs.verticallogistica.core.exception.ArquivoVazioException;
import br.com.luizalabs.verticallogistica.infra.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FileUploadServiceImpl implements IFileUploadService {


    @Override
    public void readFile(MultipartFile file) throws IOException {
        if(file.isEmpty()) {
            throw new ArquivoVazioException();
        }

        FileUtil.readFile(file);
    }
}
