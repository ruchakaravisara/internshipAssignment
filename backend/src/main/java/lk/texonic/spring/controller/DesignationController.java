package lk.texonic.spring.controller;

import lk.texonic.spring.dto.DesignationDTO;
import lk.texonic.spring.service.DesignationService;
import lk.texonic.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/designations")
@CrossOrigin
public class DesignationController {

    @Autowired
    DesignationService service;

    @PostMapping
    public ResponseEntity<ResponseUtil> addDesignation(@RequestBody DesignationDTO dto) {
        try {
            service.addDesignation(dto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseUtil("Success", "Designation added successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil("Error", "Failed to add designation: " + e.getMessage(), null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUtil> updateDesignation(@PathVariable int id, @RequestBody DesignationDTO dto) {
        try {
            service.updateDesignation(id, dto);
            return ResponseEntity.ok(new ResponseUtil("Success", "Designation updated successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil("Error", "Failed to update designation: " + e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseUtil> deleteDesignation(@PathVariable int id) {
        try {
            service.deleteDesignation(id);
            return ResponseEntity.ok(new ResponseUtil("Success", "Designation deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil("Error", "Failed to delete designation: " + e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUtil> getDesignationById(@PathVariable int id) {
        try {
            DesignationDTO designationDTO = service.getDesignationById(id);
            return ResponseEntity.ok(new ResponseUtil("Success", "Designation retrieved successfully", designationDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil("Error", "Failed to retrieve designation: " + e.getMessage(), null));
        }
    }

    @GetMapping
    public ResponseEntity<ResponseUtil> getAllDesignations() {
        try {
            List<DesignationDTO> designationDTOs = service.getAllDesignations();
            return ResponseEntity.ok(new ResponseUtil("Success", "Designations retrieved successfully", designationDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil("Error", "Failed to retrieve designations: " + e.getMessage(), null));
        }
    }
}
