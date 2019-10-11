/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabook;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Douglas.Sierra
 */
public class Book {
    
    private final  IntegerProperty id;
    private final  StringProperty tittle;
    private final  StringProperty author;
    private final  StringProperty genre;
    private final  DoubleProperty price;
    private final  IntegerProperty quantity;
    
    
    
    
    public Book(int Id,String Tittle,String Author, String Genre,double Price,int Quantity){
    this.id = new SimpleIntegerProperty(Id);
    this.tittle = new SimpleStringProperty(Tittle);
    this.author = new SimpleStringProperty(Author);
    this.genre = new SimpleStringProperty(Genre);
    this.price = new SimpleDoubleProperty(Price);
    this.quantity = new SimpleIntegerProperty(Quantity);
    }
    
    public int GetId(){return id.get();}
    public String GetTittle(){return tittle.get();}
    public String GetAuthor(){return author.get();}
    public String GetGenre(){return genre.get();}
    public double GetPrice(){return price.get();}
    public int GetQuantity(){return quantity.get();}
    
    public void SetId(int value){id.set(value);}
    public void SetTittle(String value){ tittle.set(value);}
    public void SetAuthor(String value){ author.set(value);}
    public void SetGenre(String value){ genre.set(value);}
    public void SetPrice(double value){ price.set(value);}
    public void SetQuantity(int value){ quantity.set(value);}
    
    
    public IntegerProperty idProperty(){return id;}
    public StringProperty tittleProperty(){return tittle;}
    public StringProperty authorProperty(){return author;}
    public StringProperty genreProperty(){return genre;}
    public DoubleProperty priceProperty(){return price;}
    public IntegerProperty quantityProperty(){return quantity;}
    
}
