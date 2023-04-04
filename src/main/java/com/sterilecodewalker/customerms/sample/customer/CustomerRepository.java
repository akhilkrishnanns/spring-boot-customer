package com.sterilecodewalker.customerms.sample.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;
import java.util.UUID;

@GraphQlRepository
public interface CustomerRepository extends JpaRepository<CustomerEntity,UUID> {

    /**
     * method to fetch the list of customers from the database
     * @param name String type argument to match the name
     * @return list of {@link CustomerEntity}*/
    List<CustomerEntity> findByName(String name);
}
