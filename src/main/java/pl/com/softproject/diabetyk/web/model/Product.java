/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

/**
 *
 * @author Adrian Lapierre
 */
@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 256)
    @Size(min = 3, max = 256)
    private String name;
    @Column(length = 256)
    @Size(min = 2, max = 256)
    private String description;
    @DecimalMin("0")
    private double fat;
    @DecimalMin("0")
    private double protein;
    @DecimalMin("0")
    private double carbohydrates;
    private Double weightForOneWw;
    @Column(length = 256)
    private String homeMeasure;
    @DecimalMin("0")
    private Integer wwInPortion;
    @ManyToOne
    @JoinColumn(name = "author")
    private UserData author;
    @Column
    private boolean moderated;
    
    @Column(name = "product_normalized_name", unique = true)
    private String productNormalizedName;
    
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Set<ProductCategory> categories = new HashSet<ProductCategory>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getWeightForOneWw() {
        return weightForOneWw;
    }

    public void setWeightForOneWw(Double weightForOneWw) {
        this.weightForOneWw = weightForOneWw;
    }

    public String getHomeMeasure() {
        return homeMeasure;
    }

    public void setHomeMeasure(String homeMeasure) {
        this.homeMeasure = homeMeasure;
    }

    public Integer getWwInPortion() {
        return wwInPortion;
    }

    public void setWwInPortion(Integer wwInPortion) {
        this.wwInPortion = wwInPortion;
    }

    public UserData getAuthor() {
        return author;
    }

    public void setAuthor(UserData author) {
        this.author = author;
    }

    public boolean isModerated() {
        return moderated;
    }

    public void setModerated(boolean moderated) {
        this.moderated = moderated;
    }

    public String getProductNormalizedName() {
        return productNormalizedName;
    }

    public void setProductNormalizedName(String productNormalizedName) {
        this.productNormalizedName = productNormalizedName;
    }

    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", fat=" + fat + ", protein=" + protein + ", carbohydrates=" + carbohydrates + ", weightForOneWw=" + weightForOneWw + ", homeMeasure=" + homeMeasure + '}';
    }
    
}
