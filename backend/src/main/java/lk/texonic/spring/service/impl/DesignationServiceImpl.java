package lk.texonic.spring.service.impl;

import lk.texonic.spring.dto.DesignationDTO;
import lk.texonic.spring.entity.Designation;
import lk.texonic.spring.repo.DesignationRepo;
import lk.texonic.spring.service.DesignationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DesignationRepo designationRepo;

    @Override
    public void addDesignation(DesignationDTO dto) {
        Designation designation = modelMapper.map(dto, Designation.class);
        designationRepo.save(designation);
    }

    @Override
    public void updateDesignation(int designationId, DesignationDTO dto) {
        Optional<Designation> optionalDesignation = designationRepo.findById(designationId);
        if (optionalDesignation.isPresent()) {
            Designation designation = optionalDesignation.get();
            designation.setName(dto.getName());
            designation.setRemark(dto.getRemark());
            designationRepo.save(designation);
        } else {
            throw new IllegalArgumentException("Designation not found with ID: " + designationId);
        }
    }

    @Override
    public void deleteDesignation(int designationId) {
        designationRepo.deleteById(designationId);
    }

    @Override
    public DesignationDTO getDesignationById(int designationId) {
        Optional<Designation> optionalDesignation = designationRepo.findById(designationId);
        return optionalDesignation.map(d -> modelMapper.map(d, DesignationDTO.class)).orElse(null);
    }

    @Override
    public List<DesignationDTO> getAllDesignations() {
        List<Designation> designations = designationRepo.findAll();
        return designations.stream()
                .map(d -> modelMapper.map(d, DesignationDTO.class))
                .collect(Collectors.toList());
    }
}
