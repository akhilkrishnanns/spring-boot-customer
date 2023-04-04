package com.sterilecodewalker.customerms.sample.customer;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

/**
 * Controller class for Customer related services
 * */

@Controller
public class CustomerController {

    private final CustomerService service;


    public CustomerController(CustomerService service) {
        this.service = service;
    }

    /**
     * Method used to fetch list of customers by name
     * @param name used to pass the argument as String type.
     * @return list of {@link CustomerEntity}
     * */
    @QueryMapping
    public List<CustomerEntity>  customersByName( @Argument String name){
        return service.getAllCustomers(name);
    }

    /**
     * Method used to fetch the list of all Customers
     * @return list of {@link CustomerEntity}
     * */
    @QueryMapping
    public List<CustomerEntity> listAllCustomers(){
        return service.listAllCustomers();
    }

    /**
     * Method used to add customer entity
     * @param customer is request body {@link CustomerEntity}.
     * @return {@link CustomerEntity} */
    @MutationMapping
    public CustomerEntity addCustomer(@Argument CustomerEntity customer){
        return service.saveUser(customer);
    }

    /**
     * Method used to update customer entity
     * @param customer is request body {@link CustomerEntity}.
     * @param customerId is the unique id of the user.
     * @return {@link CustomerEntity}
     * @throws NullPointerException if no user found*/
    @MutationMapping
    public CustomerEntity updateCustomer(@Argument UUID customerId,@Argument CustomerEntity customer) throws NullPointerException{
        return service.updateCustomer(customerId,customer);
    }

}
