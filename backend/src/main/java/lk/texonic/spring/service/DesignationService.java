package lk.texonic.spring.service;

import lk.texonic.spring.dto.DesignationDTO;
import lk.texonic.spring.dto.EmployeeDTO;

import java.util.List;

public interface DesignationService {
    void addDesignation(DesignationDTO dto);
    void updateDesignation(int designationId, DesignationDTO dto);
    void deleteDesignation(int designationId);
    DesignationDTO getDesignationById(int designationId);
    List<DesignationDTO> getAllDesignations();
}
