package com.bangbang.controller;

import com.bangbang.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-18 19:59
 */



@RestController
@RequestMapping("/file")
public class FileController {


    @PostMapping("/upload")
    public FileInfo upload(MultipartFile file) throws Exception{
        System.out.println("file = " + file.getContentType());

        String path = "/Users/gao/my_code_trunk/bookshop/bookshop-web/src/main/java/com/bangbang/controller";

        String extention = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
        File localFile = new File(path, System.currentTimeMillis() + "." + extention);
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }


    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String path = "/Users/gao/my_code_trunk/bookshop/bookshop-web/src/main/java/com/bangbang/controller/1563452128421.txt";

        try (InputStream input = new FileInputStream(path);
             OutputStream output = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.setHeader("ContentDisposition", "attachment;filename=text.txt");
            IOUtils.copy(input, output);

            output.flush();

        }
    }
}
