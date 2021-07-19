package com.example.androidstudio_books.dominio;

public class BooksClass {
    //attributes
    private  Long id;
    private String title, author, company;
    private int read;

    //class constructor
    public BooksClass (Long id, String title, String author, String company,  int read){
        this.id = id;
        this.title = title;
        this.author = author;
        this.company = company;
        this.read = read;
    }
    //methods

    //1_id GET
    public Long getId(){
        return id;
    }
    //id SET
    public void setId(Long id){
        this.id = id;
    }

    //2_title GET
    public String getTitle(){
        return title;
    }
    //title SET
    public void getTitle(String title){
        this.title = title;
    }

    //3_author GET
    public String getAuthor(){
        return author;
    }
    //author SET
    public void setAuthor(String author) {
        this.author = author;
    }

    //4_company GET
    public String getCompany() {
        return company;
    }
    //company SET
    public void setCompany(String company) {
        this.company = company;
    }

    //read GET
    public int getToRead(){return read;}
    //read SET
    public void setRead(int read){this.read = read;}
}
