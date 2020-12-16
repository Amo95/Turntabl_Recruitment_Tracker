package com.turntablexe.turntabl.io.controller;


import com.turntablexe.turntabl.io.exception.ResourceNotFoundException;
import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.repository.ApplicationDataRepository;
import com.turntablexe.turntabl.io.response.FileUploadResponse;
import com.turntablexe.turntabl.io.service.FileUploadService;
import com.turntablexe.turntabl.io.service.FileUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/turntablexe/")
public class ApplicantDataController {

    @Autowired
    private ApplicationDataRepository applicationDataRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/applicants")
    public List<ApplicantData> getAllApplicant() {
        return applicationDataRepository.findAll();
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<ApplicantData> getApplicantById(@PathVariable(value = "id") String applicantId)
            throws ResourceNotFoundException {
        ApplicantData applicantData = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicants not found for this id :: " + applicantId));
        return ResponseEntity.ok().body(applicantData);
    }

    @PostMapping("/applicants")
    public ApplicantData createApplicant(@Valid @RequestBody ApplicantData applicant) {
        return applicationDataRepository.save(applicant);
    }

    @PutMapping("/applicants/{id}")
    public ResponseEntity<ApplicantData> updateApplicant(@PathVariable(value = "id") String applicantId,
                                                         @Valid @RequestBody ApplicantData applicantDetails) throws ResourceNotFoundException {
        ApplicantData applicantData = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        applicantData.setFirst_name(applicantDetails.getFirst_name());
        applicantData.setLast_name(applicantDetails.getLast_name());
        applicantData.setMiddle_name(applicantDetails.getMiddle_name());
        applicantData.setNickname(applicantDetails.getNickname());
        applicantData.setDob(applicantDetails.getDob());
        applicantData.setEmail((applicantDetails.getEmail()));
        applicantData.setGender(applicantDetails.getGender());
        applicantData.setUniversity(applicantDetails.getUniversity());
        applicantData.setYear_of_graduation(applicantDetails.getYear_of_graduation());
        final ApplicantData updatedApplicant = applicationDataRepository.save(applicantData);
        return ResponseEntity.ok(updatedApplicant);
    }

    @DeleteMapping("/applicants/{id}")
    public Map<String, Boolean> deleteApplicants(@PathVariable(value = "id") String applicantId)
            throws ResourceNotFoundException {
        ApplicantData applicant = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        applicationDataRepository.delete(applicant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/applicants/upload/local")
    public void uploadToLocal(@RequestParam("file") MultipartFile file){
        fileUploadService.uploadToLocal(file);
    }

//    @PostMapping("/applicants/upload/db/")
//    public FileUploadResponse uploadCVToDB(@RequestParam("file") MultipartFile file){
//        ApplicantData applicantData = fileUploadService.uploadToDB(file);
//
//        FileUploadResponse response = new FileUploadResponse();
//        if((applicantData != null && file.getContentType().equals("application/pdf"))){
//            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                    .path("/api/turntablexe/applicants/download/")
//                    .path(applicantData.getId())
//                    .toUriString();
//            response.setDownloadUri(downloadUri);
//            response.setId(applicantData.getId());
//            response.setFileType(applicantData.getCvFiletype());
//            response.setUploadStatus(true);
//            fileUploadService.uploadToLocal(file);
//            response.setMessage("File Uploaded Successfullly");
//
//            return response;
//        }
//        response.setMessage("Something went wrong!! upload pdf file");
//        return response;
//    }

    @GetMapping("/applicants/download/{id}")
    public ResponseEntity<Resource> downloadCV(@PathVariable String id){
        ApplicantData applicantDataToRet = fileUploadService.downloadCV(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(applicantDataToRet.getCvFiletype()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + applicantDataToRet.getCvFilename())
                .body(new ByteArrayResource(applicantDataToRet.getCv()));
    }

    @PutMapping("/applicants/upload/db/{id}")
    public FileUploadResponse uploadDatabase(@PathVariable(value = "id") String applicantId, @RequestParam("file") MultipartFile file) throws ResourceNotFoundException {
        ApplicantData applicantData = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        FileUploadResponse response = new FileUploadResponse();
        ApplicantData applicantData1 = fileUploadService.uploadToDB(file);

        if((applicantData != null && file.getContentType().equals("application/pdf"))) {
            applicantData.setCv(applicantData1.getCv());
            applicantData.setCvDirectory(applicantData1.getCvDirectory());
            applicantData.setCvFiletype(applicantData1.getCvFiletype());
            applicantData.setCvFilename(applicantData1.getCvFilename());
            final ApplicantData updatedDatabase = applicationDataRepository.save(applicantData);
//          response header status
            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/turntablexe/applicants/download/db")
                    .path(applicantData.getId())
                    .toUriString();
            response.setDownloadUri(downloadUri);
            response.setId(applicantData.getId());
            response.setFileType(applicantData.getCvFiletype());
            response.setUploadStatus(true);
            response.setMessage("Updated successfully");
            return response;
        }
        response.setMessage("Bad filetype! Upload only pdf");
        return response;
    }

}