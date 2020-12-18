package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.ApplicantDatamodel;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    public void uploadToLocal(MultipartFile file);
    public ApplicantDatamodel uploadToDB(MultipartFile file, String id);
    public ApplicantDatamodel downloadCV(String applicantId);
}
