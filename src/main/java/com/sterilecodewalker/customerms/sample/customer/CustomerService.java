package com.sterilecodewalker.customerms.sample.customer;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.query.QueryByExampleDataFetcher;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    /**
     * Method used to fetch list of customers by name
     * @param name used to pass the argument as String type.
     * @return list of {@link CustomerEntity}
     * */
    public List<CustomerEntity> getAllCustomers( String name) {
        return repository.findByName(name);

    }


    /**
     * Method used to fetch list of customers
     * @return list of {@link CustomerEntity}
     * */
    public List<CustomerEntity> listAllCustomers() {
        return repository.findAll();
    }


    /**
     * Service method used to add customer entity
     * @param body is request body {@link CustomerEntity}.
     * @return {@link CustomerEntity} */
    public CustomerEntity saveUser(CustomerEntity body) {
        return repository.save(body);
    }


    /**
     * Method used to update customer entity
     * @param customer is request body {@link CustomerEntity}.
     * @param id UUID type value is the unique id of the user.
     * @return {@link CustomerEntity}
     * @throws NullPointerException if no user found*/
    public CustomerEntity updateCustomer(UUID id, CustomerEntity customer) throws NullPointerException{
        Optional<CustomerEntity> user = repository.findById(id);
        if(user.isPresent()){
            customer.setCustomerId(user.get().getCustomerId());
            return repository.save(customer);
        }else throw new NullPointerException("No Customer found");
    }

}
