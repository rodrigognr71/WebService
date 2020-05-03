package com.jalasoft.practice.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping
    public String uploadFileHandler(@RequestParam("file") MultipartFile file) {

        try {
            byte[] bytes = file.getBytes();

            // Creating the directory to store file
            String rootPath = "C:\\uploads";
            File dir = new File(rootPath);
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath()
                    + File.separator + file.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException exception) {
            System.out.println("Unsupported character set" + exception);
        }
        return "You successfully uploaded file " + file.getOriginalFilename();
    }
}
