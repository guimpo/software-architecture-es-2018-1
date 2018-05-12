
package com.mycompany.mavenproject1.ui.control;

import com.mycompany.mavenproject1.business.CountryBusiness;
import com.mycompany.mavenproject1.business.CustomerBusiness;
import com.mycompany.mavenproject1.data.Country;
import com.mycompany.mavenproject1.data.Customer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/customerController")
public class CustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             
        CountryBusiness business = new CountryBusiness();
        
        try {
            req.getSession().setAttribute("countryList", business.readAll());
        } catch (Exception ex) {
            Logger.getLogger(CountryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext()
                .getRequestDispatcher("customer.jsp")
                .forward(req, resp);
    }
        
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Country newCountry = new Country(
                                        0, 
                                        req.getParameter("inputName"), 
                                        req.getParameter("inputAcronym"), 
                                        new Integer(req.getParameter("inputDigits"))
                                        );
        
        CountryBusiness business = new CountryBusiness();
        
        try {
            business.create(newCountry);
            req.getSession().setAttribute("countryList", business.readAll());
            
        } catch (Exception ex) {
            Logger.getLogger(CountryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Customer newCustomer = new Customer();
        CustomerBusiness customerBusiness = new CustomerBusiness();
        try {
            newCustomer.setName(req.getParameter("inputCustomerName"));
            newCustomer.setAge(Integer.parseInt(req.getParameter("inputCustomerAge")));
            newCustomer.setPhone(req.getParameter("inputCustomerPhone"));
            newCustomer.setCountry(new Country());
            newCustomer.setCreditLimit(Double.parseDouble(req.getParameter("inputCustomerCreditLimit")));
            
            customerBusiness.create(newCustomer);
            req.getSession().setAttribute("customer", customerBusiness.readAll());
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
