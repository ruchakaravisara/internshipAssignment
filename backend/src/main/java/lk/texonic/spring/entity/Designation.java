package lk.texonic.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Designation {
    @Id
    private int designationId;
    private String name;
    private String remark;

    @OneToMany(mappedBy = "designation")
    private List<Employee> employees;
}

