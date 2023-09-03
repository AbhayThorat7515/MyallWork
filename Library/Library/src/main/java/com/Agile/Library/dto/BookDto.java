package com.Agile.Library.dto;

public class BookDto {


    private String bname;
    private Integer quantity;

    private String availableBook;


    public  String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAvailableBook() {
        return availableBook;
    }

    public void setAvailableBook(String availableBook) {
        this.availableBook = availableBook;
    }

    public BookDto(String bname, Integer quantity,String availableBook) {
        this.bname = bname;
        this.quantity = quantity;
        this.availableBook=availableBook;
    }



    public BookDto() {
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bname='" + bname + '\'' +
                ", quantity=" + quantity +
                ", availableBook='" + availableBook + '\'' +
                '}';
    }
}
