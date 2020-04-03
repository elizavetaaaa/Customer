package com.example.Cuscus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping(value="/")
    public String readersBooks(
            String firstName,
            Model model) {
        List<Customer> customerList =customerRepository.findByFirstName(firstName);
        if (customerList != null) {
            model.addAttribute("customers",customerList);}
        return "customerList";
    }



    @PostMapping(value = "/")
    public String addToCustomerList(
            String firstName, Customer customer) {
        customer.setFirstName(firstName);
        customerRepository.save(customer);
        return "redirect:/";}
}







/*    @GetMapping(value = "/")
    public String ind(){
        return "redirect:/customerList";
    }

}*/