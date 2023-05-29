package com.ipc.filemanagerservice.service.impl;

import com.ipc.filemanagerservice.model.CompanyInfo;
import com.ipc.filemanagerservice.service.FileReader;
import com.ipc.filemanagerservice.service.FileResourceService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FileResourceServiceImpl implements FileResourceService {
    private static final String FILE_SEPARATOR = ",";
    private static final int STRING_INDEX = 0;
    private final FileReader fileReader;

    @Override
    public CompanyInfo getCompanyInfo() {
        CompanyInfo companyInfo = new CompanyInfo();
        List<String> indexesFromFile = fileReader.readFromFile();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 1; i < indexesFromFile.size(); i++) {
            String[] parts = indexesFromFile.get(i).split(FILE_SEPARATOR);
            indexes.add(Integer.parseInt(parts[STRING_INDEX]));
        }
        companyInfo.setPostIndexes(indexes);
        return companyInfo;
    }
}
