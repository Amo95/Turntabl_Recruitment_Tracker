package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.ApplicantData;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    public void uploadToLocal(MultipartFile file);
    public ApplicantData uploadToDB(MultipartFile file);
    public ApplicantData downloadCV(String applicantId);
}
