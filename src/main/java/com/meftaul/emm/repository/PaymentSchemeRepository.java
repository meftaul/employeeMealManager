package com.meftaul.emm.repository;

import com.meftaul.emm.entity.PaymentScheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSchemeRepository extends JpaRepository<PaymentScheme, Long> {
}