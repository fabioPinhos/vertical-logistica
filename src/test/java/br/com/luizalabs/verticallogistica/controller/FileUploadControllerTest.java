package br.com.luizalabs.verticallogistica.controller;

import br.com.luizalabs.verticallogistica.application.service.impl.FileUploadServiceImpl;
import br.com.luizalabs.verticallogistica.core.exception.ArquivoVazioException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FileUploadController.class)
public class FileUploadControllerTest {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private FileUploadServiceImpl fileUploadService;


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void testUploadFile_Success() throws Exception {

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/v1/api/files/upload").file(file))
                .andExpect(status().isOk());
    }

    @Test
    void testUploadFile_BadRequest() throws Exception {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );

        Mockito.doThrow(new Throwable[]{new ArquivoVazioException()}).when(fileUploadService).readFile(any(MockMultipartFile.class));

        mvc.perform(multipart("/v1/api/files/upload").file(file))
                .andExpect(status().isBadRequest());
    }

}
