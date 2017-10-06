package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Customer;

public class CustomerService {

	
	// (Key) String 값 에 대한  (Value) Customer 값
	private Map<String, Customer> customerMap;

	
	public CustomerService() {
		customerMap = new HashMap<String , Customer>();
		
		addCustomer(new Customer("id001","allice","alice.hansung.ac.kr"));
		addCustomer(new Customer("id002","bob","bob.hansung.ac.kr"));
		addCustomer(new Customer("id003","charlie","charlie.hansung.ac.kr"));
		addCustomer(new Customer("id004","david","david.hansung.ac.kr"));
		addCustomer(new Customer("id005","trudy","trudy.hansung.ac.kr"));
	}


	private void addCustomer(Customer customer) {
		customerMap.put(customer.getId(), customer);
	}
	
	public Customer findCustomer(String id){
		if(id != null)
			return (customerMap.get(id.toLowerCase()));
		else
			return null;
	}
	public List<Customer> getAllCustomers(){
		
		List<Customer> customerList = new ArrayList<Customer>(customerMap.values());
		return customerList;
		
	}
	
}
