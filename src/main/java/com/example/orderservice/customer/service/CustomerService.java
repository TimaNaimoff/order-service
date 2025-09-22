package com.example.orderservice.customer.service;

import com.example.orderservice.common.dto.response.GenericResponseObject;
import com.example.orderservice.customer.dto.CustomerContactsDto;
import com.example.orderservice.customer.entity.Customer;
import com.example.orderservice.customer.mapper.CustomerMapper;
import com.example.orderservice.customer.repository.CustomerRepository;
import com.example.orderservice.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional(readOnly = true)
    public CustomerContactsDto getCustomerById(Long customerId){
        Customer customer = customerRepository.findById(customerId).
                orElseThrow(() -> new CustomerNotFoundException(customerId));
        return customerMapper.toDto(customer);
    }

    @Transactional(readOnly = true)
    public CustomerContactsDto getCustomerByEmail(String email , String phone){
        Customer customer = customerRepository.findByEmail(email).
                orElseGet(() -> customerRepository.findByPhone(phone).orElseThrow(()->
                new CustomerNotFoundException("Customer not found by email or phone")));
        return customerMapper.toDto(customer);
    }
    public void validateCustomerUnique(String email,String phone){
        if(customerRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Email already exists");
        }
        if(customerRepository.existsByPhone(phone)){
            throw new IllegalArgumentException("Phone already exists");
        }
    }

    @Transactional
    public GenericResponseObject<CustomerContactsDto> createCustomer(CustomerContactsDto dto) {
        validateCustomerUnique(dto.getEmail(), dto.getPhone());

        Customer customer = customerMapper.toEntity(dto);
        Customer saved = customerRepository.save(customer);

        return GenericResponseObject.<CustomerContactsDto>builder()
                .payload(customerMapper.toDto(saved))
                .timestamp(java.time.Instant.now().toString())
                .build();
    }


}
