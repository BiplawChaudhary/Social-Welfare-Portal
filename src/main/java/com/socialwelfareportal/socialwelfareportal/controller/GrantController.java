package com.socialwelfareportal.socialwelfareportal.controller;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.GrantRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.UploadDetails;
import com.socialwelfareportal.socialwelfareportal.service.impl.GrantRequestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequiredArgsConstructor
@RequestMapping("/grant")
public class GrantController {

    //Setting up the upload directory
    public static String UPLOAD_DIR = "src/main/resources/static/uploads";

    //Injecting the serviec
    private final GrantRequestServiceImpl grantRequestService;

    //Grant Homepage
    @GetMapping("/")
    public String getRegister(){
        return "/main/grantrequest/grantController";
    }

    //Method to get the grantrequest form
    @GetMapping("/register")
    public String getGrantRequestForm(Model model){
        //Adding the blank model
        model.addAttribute("grantdto", new GrantRequestDto());
        //REturning the page
        return "/main/grantrequest/grantrequestform";
    }

    @PostMapping("/register")
    public String saveGrantRequest(GrantRequestDto dto, @RequestParam("file")MultipartFile file)
            throws IOException {

        //Checking if the file is empty:
        if(!file.isEmpty()) {
            Path uploadPath = Paths.get(UPLOAD_DIR);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(file.getOriginalFilename());

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException err) {
                System.out.println(err);
            }

            //Storing the path and other data's about image in database.
            String storedImageForThymeleaf = "/uploads/" + file.getOriginalFilename();

            UploadDetails newUpload = new UploadDetails();
            newUpload.setPath(storedImageForThymeleaf);
            newUpload.setSize((int) file.getSize());
            newUpload.setFileType(file.getContentType());
        }

        return "redirect:/grant";

    }
}
