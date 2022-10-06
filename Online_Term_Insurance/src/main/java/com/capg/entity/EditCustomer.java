package com.capg.entity;

public class EditCustomer {

	
	private int customerId;
	private String cutomerName;
	private String customeraddress;
	private int customerAge;
	private long customerSalary;
	private String customerContact;
	private String customerGender;
	private String customerFamilyMembers;

	public EditCustomer(String cutomerName, String customeraddress, int customerAge, long customerSalary,
			String customerContact, String customerGender, String customerFamilyMembers) {
		super();
		this.cutomerName = cutomerName;
		this.customeraddress = customeraddress;
		this.customerAge = customerAge;
		this.customerSalary = customerSalary;
		this.customerContact = customerContact;
		this.customerGender = customerGender;
		this.customerFamilyMembers = customerFamilyMembers;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCutomerName() {
		return cutomerName;
	}

	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public long getCustomerSalary() {
		return customerSalary;
	}

	public void setCustomerSalary(long customerSalary) {
		this.customerSalary = customerSalary;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerFamilyMembers() {
		return customerFamilyMembers;
	}

	public void setCustomerFamilyMembers(String customerFamilyMembers) {
		this.customerFamilyMembers = customerFamilyMembers;
	}
}
