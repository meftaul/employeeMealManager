package com.meftaul.emm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@Entity
@Table(name = "emm_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    @SequenceGenerator(name = "order_gen", sequenceName = "order_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;

    private BigDecimal packagePrice;

    private BigDecimal employeeContributionAmount;

    private BigDecimal employerContributionAmount;

    @Lob
    private String note;

    @ManyToOne
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "fk_order_employee_id"))
    @JsonIgnoreProperties(value = {"orders"})
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "food_package_id", foreignKey = @ForeignKey(name = "fk_order_food_package_id"))
    private FoodPackage foodPackage;

}
