package com.pathbreaker.payslip.serviceImpl;

import com.pathbreaker.payslip.entity.DesignationEntity;
import com.pathbreaker.payslip.entity.PaySlipUploadEntity;
import com.pathbreaker.payslip.entity.UserEntity;
import com.pathbreaker.payslip.exception.Exceptions;
import com.pathbreaker.payslip.exception.NotFoundException;
import com.pathbreaker.payslip.mappers.PaySlipMapper;
import com.pathbreaker.payslip.repository.PaySlipRepository;
import com.pathbreaker.payslip.request.PaySlipUpdateRequest;
import com.pathbreaker.payslip.request.PaySlipsRequest;
import com.pathbreaker.payslip.response.ResultResponse;
import com.pathbreaker.payslip.service.PaySlipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class PaySlipServiceImpl implements PaySlipService {

    @Autowired
    public PaySlipServiceImpl(PaySlipRepository paySlipRepository,
                              PaySlipMapper paySlipMapper,
                              @Value("${file.upload.path}") String filePath) {
        this.paySlipRepository = paySlipRepository;
        this.paySlipMapper = paySlipMapper;
        this.PATH = filePath;
 /*       try {

            File newFile = new File(filePath);
            if (!newFile.exists()){
                newFile.mkdirs();
            }
            System.out.println("the new file name is : " +newFile.exists());

            this.PATH=filePath;
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }*/
    }
    private final PaySlipMapper paySlipMapper;
    private final PaySlipRepository paySlipRepository;
    private String PATH;

    @Override
    public ResponseEntity<?> uploadFile(PaySlipsRequest paySlipsRequest, MultipartFile file){
        try {
            System.out.println("hited service..");
            PaySlipUploadEntity paySlipUploadEntity = paySlipMapper.entityToRequest(paySlipsRequest);

            if (file.isEmpty()) {
                ResultResponse result = new ResultResponse();
                result.setResult("File cannot be empty.");
                log.info("File cannot be empty.");
                throw new NotFoundException(HttpStatus.BAD_REQUEST, "The File is empty");
            }  else {
                byte[] document = file.getBytes();
                System.out.println(document);

                String fileType = file.getContentType();
                System.out.println("The original name : " +file.getOriginalFilename());

                // Add a unique identifier to the file name
                String employeeId = paySlipUploadEntity.getEmployeeId();
                System.out.println(employeeId);
                String fileName = employeeId + "_" + file.getOriginalFilename();
                String filePath = PATH + fileName;

                file.transferTo(new File(filePath));
                paySlipUploadEntity.setFilePaths(filePath);

                paySlipRepository.save(paySlipUploadEntity);

                ResultResponse result = new ResultResponse();
                log.info("Pay slip uploaded successfully");
                result.setResult("Pay slip uploaded successfully");

                return ResponseEntity.ok(result);
            }
        } catch (Exception ex) {
            log.error("An error occurred while uploading the document", ex);
            throw new Exceptions(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while uploading the document");
        }
    }

    @Override
    public ResponseEntity<byte[]> getPayslipById(Long id) {

        try {
            Optional<PaySlipUploadEntity> paySlipUploadEntity = paySlipRepository.findById(id);

            if (paySlipUploadEntity.isPresent()) {
                PaySlipUploadEntity paySlipUpload = paySlipUploadEntity.get();
                String filePath = paySlipUpload.getFilePaths();

                byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));

                HttpHeaders headers = new HttpHeaders();
                // Determine content type based on file extension
                String contentType = Files.probeContentType(Paths.get(filePath));
                headers.setContentType(MediaType.parseMediaType(contentType));

                // Set content disposition to "inline" to display in the browser
                headers.setContentDisposition(ContentDisposition.builder("inline").filename(StringUtils.getFilename(filePath)).build());

                return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
            } else {
                log.error("Pay slip  showing Document with ID " + id + " not found", id);
                throw new NotFoundException(HttpStatus.NOT_FOUND, "The showing Document with ID " + id + " not found");
            }
        } catch (IOException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            log.error("Error occurred while showing the document " + e);
            throw new Exceptions(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while retrieving the document " + e);
        }
    }



        @Override
    public ResponseEntity<?> downlaodPayslipById(Long id) {
        try {
            Optional<PaySlipUploadEntity> paySlipUploadEntity = paySlipRepository.findById(id);

            if (paySlipUploadEntity.isPresent()) {
                PaySlipUploadEntity entity = paySlipUploadEntity.get();
                String path = entity.getFilePaths();
                Path documentPath = Paths.get(path);
                byte[] documentBytes = Files.readAllBytes(documentPath);

                HttpHeaders headers = new HttpHeaders();
                // Determine content type based on file extension
                String contentType = Files.probeContentType(documentPath);
                headers.setContentType(MediaType.parseMediaType(contentType));

                // Set content disposition to "attachment" to trigger download
                String fileName = StringUtils.getFilename(path);
                headers.setContentDispositionFormData("attachment", fileName);

                return new ResponseEntity<>(documentBytes, headers, HttpStatus.OK);
            } else {
                log.error("Pay slip  Document with ID " + id + " not found", id);
                throw new NotFoundException(HttpStatus.NOT_FOUND, "The Document with ID " + id + " not found");
            }
        } catch (IOException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            log.error("Error occurred while retrieving the document " + e);
            throw new Exceptions(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while retrieving the document " + e);
        }
    }

    @Override
    public ResponseEntity<?> updatePayslipById(Long id, PaySlipUpdateRequest paySlipsRequest, MultipartFile file) {
        try {
            System.out.println("hited service..");
            Optional<PaySlipUploadEntity> optionalPaySlip = paySlipRepository.findById(id);

            if (optionalPaySlip.isPresent()) {
                PaySlipUploadEntity existingPaySlip = optionalPaySlip.get();
                System.out.println(existingPaySlip.getFilePaths());
                paySlipMapper.entityToUpdateRequest(paySlipsRequest, existingPaySlip);

                if (file != null && !file.isEmpty()) {
                    byte[] document = file.getBytes();
                    System.out.println(document);

                    String fileType = file.getContentType();
                    System.out.println("The original name : " + file.getOriginalFilename());

                    // Add a unique identifier to the file name
                    String employeeId = existingPaySlip.getEmployeeId();
                    String fileName = employeeId + "_" + file.getOriginalFilename();
                    String filePath = PATH + fileName;

                    // Delete the existing file
                    Path existingFilePath = Paths.get(existingPaySlip.getFilePaths());
                    Files.delete(existingFilePath);
                    // Save the new file
                    file.transferTo(new File(filePath));
                    existingPaySlip.setFilePaths(filePath);
                }

                // Save the updated entity
                paySlipRepository.save(existingPaySlip);

                ResultResponse result = new ResultResponse();
                log.info("Pay slip is updated successfully");
                result.setResult("Pay slip is updated successfully");

                return ResponseEntity.ok(result);
            } else {
                throw new NotFoundException(HttpStatus.NOT_FOUND, "Pay slip with ID " + id + " not found");
            }
        } catch (Exception ex) {
            log.error("An error occurred while updating the pay slip", ex);
            throw new Exceptions(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while updating the pay slip");
        }
    }

    @Override
    public ResponseEntity<?> deletePayslipById(Long id) {
        try {
            Optional<PaySlipUploadEntity> optionalPaySlip = paySlipRepository.findById(id);

            if (optionalPaySlip.isPresent()) {
                PaySlipUploadEntity existingPaySlip = optionalPaySlip.get();

                // Delete the associated file
                Path existingFilePath = Paths.get(existingPaySlip.getFilePaths());
                Files.deleteIfExists(existingFilePath);

                // Delete the entity from the database
                paySlipRepository.deleteById(id);

                ResultResponse result = new ResultResponse();
                log.info("Pay slip with ID {} is deleted successfully", id);
                result.setResult("Pay slip is deleted successfully");

                return ResponseEntity.ok(result);
            } else {
                throw new NotFoundException(HttpStatus.NOT_FOUND, "Pay slip with ID " + id + " not found");
            }
        } catch (Exception ex) {
            log.error("An error occurred while deleting the pay slip", ex);
            throw new Exceptions(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while deleting the pay slip");
        }
    }

}
