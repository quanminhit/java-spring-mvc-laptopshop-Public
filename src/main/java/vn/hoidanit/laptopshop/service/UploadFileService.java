package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import jakarta.servlet.ServletContext;

@Service
public class UploadFileService {
    private final ServletContext servletContext;

    public UploadFileService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveFile(MultipartFile file, String targetFolder) {
        String finalName = "";
        if (file.isEmpty()) {
            return "";
        }
        try {
            byte[] bytes = file.getBytes();
            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return finalName;
    }
}
