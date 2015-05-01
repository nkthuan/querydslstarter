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

    public void copyFields(BranchLocation copy) {
        this.bankName = copy.bankName;
        this.branchName = copy.branchName;
        this.address = copy.address;
        this.city = copy.city;
        this.state = copy.state;
        this.zip = copy.zip;
        this.country = copy.country;
        this.phoneNumber = copy.phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "BranchLocation[id=%d, bankName='%s', branchName='%s', address='%s', city='%s', state='%s', zip='%s', country='%s', phoneNumber='%s']",
                id, bankName, branchName, address, city, state, zip, country, phoneNumber);
    }

}

