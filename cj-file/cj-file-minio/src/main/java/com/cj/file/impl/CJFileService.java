package com.cj.file.impl;

import com.cj.file.common.IFileService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class CJFileService implements IFileService {
    @Override
    public Map<String, Object> upload(MultipartFile file, Map<String, Object> entity, HttpServletResponse response, HttpServletRequest request) {
        return null;
    }

    @Override
    public void download(Map<String, Object> fileInfo, HttpServletResponse response, HttpServletRequest request) {

    }
}
