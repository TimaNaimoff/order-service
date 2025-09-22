package com.example.orderservice.mapper;


import com.example.orderservice.dto.CustomerContactsDto;
import com.example.orderservice.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerContactsDto toDto(Customer customer);


    Customer toEntity(CustomerContactsDto customer);

    List<CustomerContactsDto> toDtoList(List<Customer>customers);
}
