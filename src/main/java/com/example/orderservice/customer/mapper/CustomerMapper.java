package com.example.orderservice.customer.mapper;


import com.example.orderservice.customer.dto.CustomerContactsDto;
import com.example.orderservice.customer.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerContactsDto toDto(Customer customer);


    Customer toEntity(CustomerContactsDto customer);

    List<CustomerContactsDto> toDtoList(List<Customer>customers);
}
