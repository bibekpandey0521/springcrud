package com.appsoft.springcrudproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appsoft.springcrudproject.model.Customer;
import com.appsoft.springcrudproject.service.CustomerService;

@Controller
public class HomeController {

	private final CustomerService customerService;

	public HomeController(CustomerService customerService) {

		this.customerService = customerService;
	}

	@GetMapping("/")
	public String home(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
//		String sayHello = "Hello" + name;
//		model.addAttribute("message", sayHello);
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customerList",customerList);
		return "Home";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "create";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer,Model model) {
		customerService.save(customer);
		return "redirect:/";
		
	}

}
