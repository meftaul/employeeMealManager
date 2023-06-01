package com.meftaul.emm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(name = "employee_id_unique", columnNames = "employeeId")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    /*@Column(name = "employee_id", unique = true, nullable = false)*/
    private String employeeId;

    private String firstName;
    private String lastName;
    private String designation;



    @ManyToOne
    @JoinColumn(name = "payment_scheme_id", foreignKey = @ForeignKey(name = "fk_employee_payment_scheme_id"))
    @JsonIgnoreProperties(value = {"employees"})
    private PaymentScheme paymentScheme;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orders = new HashSet<>();

}
