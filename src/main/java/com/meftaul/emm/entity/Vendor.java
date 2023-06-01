package com.meftaul.emm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_gen")
    @SequenceGenerator(name = "vendor_gen", sequenceName = "vendor_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "vendor")
    @JsonIgnoreProperties(value = {"vendor"})
    private Set<FoodPackage> foodPackages;

}
