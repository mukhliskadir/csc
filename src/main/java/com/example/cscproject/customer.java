package com.example.cscproject;

import java.io.Serializable;

public class customer implements Serializable {

    public int custID;
    public String custName;
    public String custPhone;
    public String custNRIC;
    public String custAddress;
    public String custUsername;
    public String custPassword;
    public String custLicenseNo;

    public customer(){}

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustNRIC() {
        return custNRIC;
    }

    public void setCustNRIC(String custNRIC) {
        this.custNRIC = custNRIC;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustLicenseNo() {
        return custLicenseNo;
    }

    public void setCustLicenseNo(String custLicenseNo) {
        this.custLicenseNo = custLicenseNo;
    }

    @Override
    public String toString() {
        return "customer{" +
                "custID=" + custID +
                ", custName='" + custName + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custNRIC='" + custNRIC + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custUsername='" + custUsername + '\'' +
                ", custPassword='" + custPassword + '\'' +
                ", custLicenseNo='" + custLicenseNo + '\'' +
                '}';
    }
}

