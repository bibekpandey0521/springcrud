package com.appsoft.springcrudproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.appsoft.springcrudproject.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
	
	
}
