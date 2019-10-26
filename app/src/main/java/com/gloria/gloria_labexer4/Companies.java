package com.gloria.gloria_labexer4;

public class Companies {

    private int logo;
    private String companyName,companyCountry,companyCEO,companyIndustry,companyDesc;

    public Companies(int logo, String companyName, String companyCountry, String companyCEO, String companyIndustry, String companyDesc) {
        this.logo = logo;
        this.companyName = companyName;
        this.companyCountry = companyCountry;
        this.companyCEO = companyCEO;
        this.companyIndustry = companyIndustry;
        this.companyDesc = companyDesc;
    }

    public int getLogo() {
        return logo;
    }

    public String getcompanyName() {
        return companyName;
    }

    public String getcompanyCountry() {
        return companyCountry;
    }

    public String getcompanyCEO() {
        return companyCEO;
    }

    public String getcompanyIndustry() {
        return companyIndustry;
    }

}