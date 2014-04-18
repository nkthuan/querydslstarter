package com.credera.querydsl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BranchLocation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String bankName;
    private String branchName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phoneNumber;

    protected BranchLocation() {}

    public BranchLocation(String bankName, String branchName, String address, String city,
			String state, String zip, String country, String phoneNumber) {
		super();
		this.bankName = bankName;
		this.branchName = branchName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phoneNumber = phoneNumber;
	}



	@Override
    public String toString() {
        return String.format(
                "BranchLocation[id=%d, bankName='%s', branchName='%s', address='%s', city='%s', state='%s', zip='%s', country='%s', phoneNumber='%s']",
                id, bankName, branchName, address, city, state, zip, country, phoneNumber);
    }

}

