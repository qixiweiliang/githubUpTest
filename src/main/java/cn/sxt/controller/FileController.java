package cn.sxt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @program: SptingBoot_upload
 * @Date: 2019/2/19 19:35
 * @Author: Mr.Wen
 * @Description:
 */
@Controller
@RequestMapping("upload")
public class FileController {
    @Value("${fileupload.uploadlocation}")
    private String location;

    @RequestMapping("uploadFile")
    public String uploadFile(MultipartFile mf) {
        String filename = mf.getOriginalFilename();
        File file = new File(location, filename);
        try {
            mf.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "suuccess";
    }

}
