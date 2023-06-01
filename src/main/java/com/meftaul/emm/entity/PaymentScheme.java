package com.meftaul.emm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "paymentScheme")
public class PaymentScheme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_scheme_gen")
    @SequenceGenerator(name = "payment_scheme_gen", sequenceName = "payment_scheme_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal employerContribution;
    private Boolean percentage;

    @OneToMany(mappedBy = "paymentScheme")
    @JsonIgnoreProperties(value = {"paymentScheme"})
    private Set<Employee> employees;

}
