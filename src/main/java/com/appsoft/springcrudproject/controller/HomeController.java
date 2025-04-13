package com.appsoft.springcrudproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appsoft.springcrudproject.model.Customer;
import com.appsoft.springcrudproject.service.CustomerService;

import jakarta.validation.Valid;

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
		model.addAttribute("customerList", customerList);
		return "home";
	}

	@GetMapping("/create")
	public String create(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "create";
	}

//	@PostMapping("/save")
//	public String save(@ModelAttribute("customer") Customer customer,Model model) {
//		customerService.save(customer);
//		return "redirect:/";
//		
//	}
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "create";
		}
		customerService.save(customer);
		redirectAttributes.addFlashAttribute("message", "Customer created Successfully");

		return "redirect:/";

	}
	
//	@GetMapping("customer/{id}")
//	public String show(@PathVariable int id, Model model) {
//		 Optional<Customer> customer= customerService.findById(id);
//		customer.ifPresent(value->model.addAttribute("customer",customer));
//		return "show";		
//	}

	 @GetMapping("/customer/{id}")
	    public String customer(@PathVariable int id, Model model) {
	        Optional<Customer> customer = customerService.findById(id);

	        customer.ifPresent(value -> model.addAttribute("customer", value));

	        return "show";
	    }
	@GetMapping("customer/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		Customer customer = customerService.findById(id).orElse(null);
		model.addAttribute("customer", customer);
		return "create";
	}

	@GetMapping("customer/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
		customerService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "customer deleted Succesffully");
		return "redirect:/";
	}

}
