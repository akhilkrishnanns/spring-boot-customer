package com.sterilecodewalker.customerms.sample.customer;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;
/**
 * Customer Entity Class*/

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "UUID")
    @Column
    private UUID customerId;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String email;



}
