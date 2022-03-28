package org.example.ch5.progmodel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  //将其设置为XML文档
public class Computer {

    private String brand;

    private String serialNumber;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
