package com.appsoft.springcrudproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.appsoft.springcrudproject.model.Customer;
import com.appsoft.springcrudproject.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepositroy) {
		this.customerRepository = customerRepositroy;
	}
	
	public List<Customer> getAllCustomers(){
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Optional<Customer> findById(int id){
		return customerRepository.findById(id);
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}
}
