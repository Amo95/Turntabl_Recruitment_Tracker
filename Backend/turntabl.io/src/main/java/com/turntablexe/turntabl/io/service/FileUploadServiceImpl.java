package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.exception.ResourceNotFoundException;
import com.turntablexe.turntabl.io.model.ApplicantDatamodel;
import com.turntablexe.turntabl.io.repository.ApplicationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final String fileUploadPath = "C:\\Users\\TURNTABL\\Desktop\\Turntabl_Recruitment_Tracker\\Backend\\turntabl.io\\src\\uploads";

    @Autowired
    private ApplicationDataRepository applicationDataRepository;

//    ApplicantData applicantData = new ApplicantData();

    @Override
    public void uploadToLocal(MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(fileUploadPath + file.getOriginalFilename());
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ApplicantDatamodel uploadToDB(MultipartFile file, String id) {
        try {
            ApplicantDatamodel applicantDatamodel = applicationDataRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + id));
            applicantDatamodel.setCvDirectory(Paths.get(fileUploadPath + file.getOriginalFilename()).toString());
            applicantDatamodel.setCv(file.getBytes());
            applicantDatamodel.setCvFilename(file.getOriginalFilename());
            applicantDatamodel.setCvFiletype(file.getContentType());
            ApplicantDatamodel applicantDatamodel1ToRet = applicationDataRepository.save(applicantDatamodel);
            return applicantDatamodel1ToRet;

        } catch (IOException | ResourceNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public ApplicantDatamodel downloadCV(String applicantId) {
        ApplicantDatamodel uploadedFiletoRet = applicationDataRepository.getOne(applicantId);
        return uploadedFiletoRet;
    }
}
