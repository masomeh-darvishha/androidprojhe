package com.example.projeh;

public class Cmodel {
    private String logo,name,price ,id ;
    public Cmodel(String logo, String name, String price, String id) {
        this.logo = logo;
        this.name = name;
        this.price = price;
        this.id = id;

    }
public Cmodel()
{

}


    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
