/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.diabetyk.web.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    
    @ManyToMany(mappedBy="products")
    private Set<ProductCategory> categories;

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

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
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

    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
    }

    public Integer getWwInPortion() {
        return wwInPortion;
    }

    public void setWwInPortion(Integer wwInPortion) {
        this.wwInPortion = wwInPortion;
    }

    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", fat=" + fat + ", protein=" + protein + ", carbohydrates=" + carbohydrates + ", weightForOneWw=" + weightForOneWw + ", homeMeasure=" + homeMeasure + '}';
    }
    
}
