/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.business;

import com.mycompany.mavenproject1.data.Country;
import com.mycompany.mavenproject1.data.Customer;
import java.util.Set;

/**
 *
 * @author paulo
 */
public class Facade {
    
    private CountryBusiness countryBusiness;
    private CustomerBusiness customerBusiness;
    
    public Facade(){
        countryBusiness = new CountryBusiness();
        customerBusiness = new CustomerBusiness();
    }
    
    public void create(Country country) throws Exception{
        countryBusiness.create(country);
    }
    
    public Set<Country> readAllCountry(){
        return countryBusiness.readAll();
    }
       
    public void create(Customer customer) throws Exception{
        customerBusiness.create(customer);
    }
    
    public Set<Customer> readAllCustomer(){
        return customerBusiness.readAll();
    }
}
