package com.turntablexe.turntabl.io.controller;


import com.turntablexe.turntabl.io.exception.ResourceNotFoundException;
import com.turntablexe.turntabl.io.model.ApplicantDatamodel;
import com.turntablexe.turntabl.io.repository.ApplicationDataRepository;
import com.turntablexe.turntabl.io.response.FileUploadResponse;
import com.turntablexe.turntabl.io.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3006"})
@RestController
@RequestMapping("/api/turntablexe/")
public class ApplicantDataController {

    @Autowired
    private ApplicationDataRepository applicationDataRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/applicants")
    public List<ApplicantDatamodel> getAllApplicant() {
        return applicationDataRepository.findAll();
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<ApplicantDatamodel> getApplicantById(@PathVariable(value = "id") String applicantId)
            throws ResourceNotFoundException {
        ApplicantDatamodel applicantDatamodel = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicants not found for this id :: " + applicantId));
        return ResponseEntity.ok().body(applicantDatamodel);
    }

    @PostMapping("/applicants")
    public HttpStatus createApplicant(@Valid @RequestBody ApplicantDatamodel applicant) {
        applicationDataRepository.save(applicant);
        return  HttpStatus.valueOf(200);
    }

    @PutMapping("/applicants/{id}")
    public ResponseEntity<ApplicantDatamodel> updateApplicant(@PathVariable(value = "id") String applicantId,
                                                              @Valid @RequestBody ApplicantDatamodel applicantDetails) throws ResourceNotFoundException {
        ApplicantDatamodel applicantDatamodel = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        applicantDatamodel.setFirst_name(applicantDetails.getFirst_name());
        applicantDatamodel.setLast_name(applicantDetails.getLast_name());
        applicantDatamodel.setMiddle_name(applicantDetails.getMiddle_name());
        applicantDatamodel.setNickname(applicantDetails.getNickname());
        applicantDatamodel.setDob(applicantDetails.getDob());
        applicantDatamodel.setEmail((applicantDetails.getEmail()));
        applicantDatamodel.setGender(applicantDetails.getGender());
        applicantDatamodel.setUniversity(applicantDetails.getUniversity());
        applicantDatamodel.setYear_of_graduation(applicantDetails.getYear_of_graduation());
        applicantDatamodel.setAddress1(applicantDetails.getAddress1());
        applicantDatamodel.setAddress2(applicantDetails.getAddress2());
        applicantDatamodel.setCity(applicantDetails.getCity());
        applicantDatamodel.setZip_code(applicantDetails.getZip_code());
        applicantDatamodel.setPhone_number(applicantDetails.getPhone_number());
        applicantDatamodel.setWhatsApp_number(applicantDetails.getWhatsApp_number());
        applicantDatamodel.setSsnit_number(applicantDetails.getSsnit_number());
        applicantDatamodel.setNss_number(applicantDetails.getNss_number());
        applicantDatamodel.setReferral(applicantDetails.getReferral());
        applicantDatamodel.setRegion(applicantDetails.getRegion());
        final ApplicantDatamodel updatedApplicant = applicationDataRepository.save(applicantDatamodel);
        return ResponseEntity.ok(updatedApplicant);
    }

    @DeleteMapping("/applicants/{id}")
    public Map<String, Boolean> deleteApplicants(@PathVariable(value = "id") String applicantId)
            throws ResourceNotFoundException {
        ApplicantDatamodel applicant = applicationDataRepository.findById(applicantId)
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
        ApplicantDatamodel applicantDatamodelToRet = fileUploadService.downloadCV(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(applicantDatamodelToRet.getCvFiletype()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + applicantDatamodelToRet.getCvFilename())
                .body(new ByteArrayResource(applicantDatamodelToRet.getCv()));
    }

    @PutMapping("/applicants/upload/db/{id}")
    public FileUploadResponse uploadDatabase(@PathVariable(value = "id") String applicantId, @RequestParam("file") MultipartFile file) throws ResourceNotFoundException {
        ApplicantDatamodel applicantDatamodel = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        FileUploadResponse response = new FileUploadResponse();
        ApplicantDatamodel applicantDatamodel1 = fileUploadService.uploadToDB(file, applicantId);

        if((applicantDatamodel != null && file.getContentType().equals("application/pdf"))) {

            applicantDatamodel.setCv(applicantDatamodel1.getCv());
            applicantDatamodel.setCvDirectory(applicantDatamodel1.getCvDirectory());
            applicantDatamodel.setCvFiletype(applicantDatamodel1.getCvFiletype());
            applicantDatamodel.setCvFilename(applicantDatamodel1.getCvFilename());
            final ApplicantDatamodel updatedDatabase = applicationDataRepository.save(applicantDatamodel);
//          response header status
            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/turntablexe/applicants/download/")
                    .path(applicantDatamodel.getId())
                    .toUriString();
            response.setDownloadUri(downloadUri);
            response.setId(applicantDatamodel.getId());
            response.setFileType(applicantDatamodel.getCvFiletype());
            response.setUploadStatus(true);
            response.setMessage("Updated successfully");
            return response;
        }
        response.setMessage("Bad filetype! Upload only pdf");
        return response;
    }

}