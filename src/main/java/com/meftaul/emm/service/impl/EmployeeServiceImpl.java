package com.meftaul.emm.service.impl;

import com.meftaul.emm.dto.EmployeeDto;
import com.meftaul.emm.entity.Employee;
import com.meftaul.emm.entity.PaymentScheme;
import com.meftaul.emm.repository.EmployeeRepository;
import com.meftaul.emm.repository.PaymentSchemeRepository;
import com.meftaul.emm.service.EmmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmmService<Employee, Long> {

    private final EmployeeRepository employeeRepository;
    private final PaymentSchemeRepository paymentSchemeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PaymentSchemeRepository paymentSchemeRepository) {
        this.employeeRepository = employeeRepository;
        this.paymentSchemeRepository = paymentSchemeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee saveEmployeeDto(EmployeeDto employeeDto) {

        if (employeeRepository.existsByEmployeeId(employeeDto.getEmployeeId())) {
            throw new RuntimeException("Invalid employee id.");
        }
        PaymentScheme paymentScheme = null;

        if (Objects.nonNull(employeeDto.getPaymentSchemeId())) {
            paymentScheme = paymentSchemeRepository
                    .findById(employeeDto.getPaymentSchemeId())
                    .orElseThrow(() -> new RuntimeException("Invalid payment scheme id."));
        }

        Employee employee = new Employee();
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setPaymentScheme(paymentScheme);

        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getList(Pageable page) {
        return employeeRepository.findAll(page);
    }

    @Override
    public Employee getById(Long aLong) {
        return null;
    }

    public Employee getEmployeeByEmployeeId(String employeeId) {
        return employeeRepository
                .findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with ID: "+ employeeId + " not found"));
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }
}
