package com.muratyuksel.ogrenciler;

public class Ogrenci {

    Integer id;
    String name;
    String no;
    String dogumTarihi;

    public Ogrenci() { }

    public Ogrenci(String name, String no, String dogumTarihi) {
        this.name = name;
        this.no = no;
        this.dogumTarihi = dogumTarihi;
    }

    public Ogrenci(Integer id, String name, String no, String dogumTarihi) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.dogumTarihi = dogumTarihi;
    }

    @Override
    public String toString() {
        return name + " (" + dogumTarihi + ")";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

}
