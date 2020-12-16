package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.exception.ResourceNotFoundException;
import com.turntablexe.turntabl.io.model.ApplicantData;
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

    private final String fileUploadPath = "/media/james/444FE6C10F431832/";

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
    public ApplicantData uploadToDB(MultipartFile file, String id) {
        try {
            ApplicantData applicantData = applicationDataRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + id));
            applicantData.setCvDirectory(Paths.get(fileUploadPath + file.getOriginalFilename()).toString());
            applicantData.setCv(file.getBytes());
            applicantData.setCvFilename(file.getOriginalFilename());
            applicantData.setCvFiletype(file.getContentType());
            ApplicantData applicantData1ToRet = applicationDataRepository.save(applicantData);
            return applicantData1ToRet;

        } catch (IOException | ResourceNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public ApplicantData downloadCV(String applicantId) {
        ApplicantData uploadedFiletoRet = applicationDataRepository.getOne(applicantId);
        return uploadedFiletoRet;
    }
}
