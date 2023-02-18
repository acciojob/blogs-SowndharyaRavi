package com.driver.models;



import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String describtion;

    private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image() {
    }

    public Image(String describtion, String dimensions, Blog blog) {
        this.describtion = describtion;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    public Image(int id, String describtion, String dimensions, Blog blog) {
        this.id = id;
        this.describtion = describtion;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}