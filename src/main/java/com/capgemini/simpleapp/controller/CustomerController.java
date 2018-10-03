package com.capgemini.simpleapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.entities.Customer.editProfileCheck;
import com.capgemini.simpleapp.entities.Customer.loginCheck;
import com.capgemini.simpleapp.exception.WrongCredentialsException;
import com.capgemini.simpleapp.service.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage() {
		return "iciciHome";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String getLoginPage(Model model, HttpServletRequest httpRequest) {

		Cookie[] cookies = httpRequest.getCookies();
		if (cookies == null) {
			return "enableCookies";

		} else {
			model.addAttribute("customer", new Customer());
			return "login";
		}

	}

	@RequestMapping(value = "/logoutSession", method = RequestMethod.GET)
	public String getLogout(HttpSession session,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		session.invalidate();
		return "logout";
	}

	@ModelAttribute("customer")
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView getAuthentication(@Validated({ loginCheck.class }) @ModelAttribute Customer customer,
			BindingResult bindingResult, Model model)
			throws EmptyResultDataAccessException, WrongCredentialsException {
		ModelAndView modelAndView=new  ModelAndView() ;
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.toString());
			modelAndView.setViewName("login");
			return modelAndView ;
		}
		customer = service.authenticate(customer);
		modelAndView.addObject("customer", customer) ;
		
//		session.setAttribute("customer", customer);
		modelAndView.setViewName("dashboard");
		return modelAndView ;

	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashboardPage() {
		return "dashboard";
	}

	@RequestMapping(value = "/editProfilePage", method = RequestMethod.GET)
	public String getEditProfilePage(@ModelAttribute Customer customer,Model model) {
		model.addAttribute("customer", customer);
		return "/editProfile";
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView getEditProfile(@Validated({ editProfileCheck.class }) @ModelAttribute Customer customer,
			BindingResult bindingResult,@ModelAttribute("customer") Customer sessionCustomer) {
		ModelAndView modelAndView=new ModelAndView() ;
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.toString());
			modelAndView.setViewName("editProfile");
			return modelAndView ;
		}

		Customer newCustomer = sessionCustomer;
		customer.setAccount(newCustomer.getAccount());
		customer.setCustomerId(newCustomer.getCustomerId());
		customer.setPassword(newCustomer.getPassword());
		service.updateProfile(customer);
//		session.setAttribute("customer", customer);
		modelAndView.addObject("customer", sessionCustomer) ;
		modelAndView.setViewName("editProfileSuccess") ;
		return modelAndView;
	}

	@RequestMapping(value = "/updatePasswordPage", method = RequestMethod.GET)
	public String getUpdatePasswordPage() {
		return "updatePassword";
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public String getUpdatePassword( @RequestParam("newPassword") String newPassword,
			@RequestParam("oldPassword") String oldPassword,@ModelAttribute("customer") Customer sessionCustomer) {
	
		if (!service.updatePassword(sessionCustomer, newPassword, oldPassword)) {
			return "/updatePasswordError";
		} else {
			sessionCustomer.setPassword(newPassword);
//			session.setAttribute("customer", customer);
			return "/updatePasswordSuccess";
		}
	}
	

	/*
	 * @RequestMapping(value = "/addEmployeePage", method = RequestMethod.GET)
	 * public String getAddEmployeePage(Model model) {
	 * model.addAttribute("employee", new Employee()); return "addEmployeeForm"; }
	 * 
	 * @RequestMapping(value = "/addEmployee", method = RequestMethod.POST) public
	 * String addNewEmployee(@ModelAttribute Employee employee) {
	 * employeeService.addEmployee(employee); return "redirect:/findAllEmployees";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/findAllEmployees", method = RequestMethod.GET)
	 * public String getAllEmployeeDetails(Model model) { List<Employee> employees =
	 * employeeService.findAllEmployees(); model.addAttribute("allEmployees",
	 * employees); return "allEmployees"; }
	 * 
	 * @RequestMapping(value = "/deleteEmployee/{employeeId}", method =
	 * RequestMethod.GET) public String deleteEmployee(@PathVariable int employeeId)
	 * { employeeService.deleteEmployee(employeeId); return
	 * "redirect:/findAllEmployees"; }
	 * 
	 * @RequestMapping(value = "/editEmployeePage/{employeeId}", method =
	 * RequestMethod.GET) public String editEmployeePage(Model model, @PathVariable
	 * int employeeId) { Employee employee =
	 * employeeService.findEmployeeById(employeeId); model.addAttribute("employee",
	 * employee); return "updateEmployeeForm"; }
	 * 
	 * @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	 * public String updateEmployee(@ModelAttribute Employee employee) {
	 * employeeService.updateEmployee(employee); return
	 * "redirect:/findAllEmployees";
	 * 
	 * }
	 */
}
