/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
public class UploadController {

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }

    @RequestMapping(value = "upload01", method = RequestMethod.POST)
    public String upload01(HttpServletRequest req) throws IOException {
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
        MultipartFile file = mhsr.getFile("file");

        String contentType = file.getContentType();
        long size = file.getSize();
        Resource resource = file.getResource();
        String name = file.getName();
        String ofName = file.getOriginalFilename();
        System.out.println("contentType = " + contentType
                + "\nsize = " + size
                + "\nresource = " + resource.toString()
                + "\nname = " + name
                + "\noriginalFilename = " + ofName
        );

        String rp = req.getServletContext().getRealPath("/");
        File path = new File(rp + "/upload");
        if (!path.exists()) {
            path.mkdirs();
        }
        file.transferTo(new File(path, ofName));

        return "upload";
    }

    @RequestMapping(value = "upload02", method = RequestMethod.POST)
    public String upload02(HttpServletRequest req, MultipartFile file) throws IOException {
        saveFile(req, file);

        return "upload";
    }

    @RequestMapping(value = "upload03", method = RequestMethod.POST)
    public String upload03(HttpServletRequest req,
                           @RequestParam("files") List<MultipartFile> files
    ) throws IOException {
        if (files == null || files.size() <= 0) {

        } else {
            for (MultipartFile file : files) {
                saveFile(req, file);
            }
        }

        return "upload";
    }

    public void saveFile(HttpServletRequest req, MultipartFile file) {
        if (file.isEmpty()) {
            req.setAttribute("msg", "请选择要上传的文件！");
        } else {
            String rp = req.getServletContext().getRealPath("/");
            File path = new File(rp + "/upload");
            if (!path.exists()) {
                path.mkdirs();
            }

            String ofName = file.getOriginalFilename();
            String suffix;
            if (ofName == null || "".equals(ofName)) {
                suffix = ".pic";
            } else {
                suffix = ofName.substring(ofName.lastIndexOf("."));
            }
            String name = System.currentTimeMillis() + suffix;

            try {
                file.transferTo(new File(path, name));
            } catch (IOException | IllegalStateException ex) {
                Logger.getLogger(UploadController.class.getName()).log(Level.SEVERE, null, ex);
            }
            req.setAttribute("msg", "文件上传成功！");
        }
    }
}
