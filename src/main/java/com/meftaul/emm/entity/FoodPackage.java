package com.meftaul.emm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "food_package")
public class FoodPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_package_gen")
    @SequenceGenerator(name = "food_package_gen", sequenceName = "food_package_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Lob
    private String itemDetails;

    private BigDecimal price;

    private LocalDate effectiveFromDate;

    @ManyToOne
    @JoinColumn(name = "vendor_id", foreignKey = @ForeignKey(name = "fk_food_package_vendor_id"))
    @JsonIgnoreProperties(value = {"foodPackages"})
    private Vendor vendor;

}
