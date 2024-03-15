package lk.texonic.spring.repo;

import lk.texonic.spring.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepo extends JpaRepository<Designation ,Integer> {
}
