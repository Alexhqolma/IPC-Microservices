package com.ipc.filemanagerservice.resource;

import com.ipc.filemanagerservice.model.CompanyInfo;
import com.ipc.filemanagerservice.service.FileResourceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class FileResource {
    private final FileResourceService fileResourceService;

    @GetMapping
    public CompanyInfo getCompanyInfo() {
        return fileResourceService.getCompanyInfo();
    }
}
