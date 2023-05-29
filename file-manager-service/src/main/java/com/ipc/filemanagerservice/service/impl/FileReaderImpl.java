package com.ipc.filemanagerservice.service.impl;

import com.ipc.filemanagerservice.exception.FileManagerServiceException;
import com.ipc.filemanagerservice.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileReaderImpl implements FileReader {
    @Value("${filepath.url}")
    private String filepathUrl;

    @Override
    public List<String> readFromFile() {
        try {
            return Files.readAllLines(Path.of(filepathUrl));
        } catch (IOException e) {
            throw new FileManagerServiceException("Can't find file " + filepathUrl);
        }
    }
}
