package com.vits.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Supplier {
    public Supplier(Long id, String name, String contactInfo, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
		this.products = products;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactInfo;

    @OneToMany(mappedBy = "supplier")
    private Set<Product> products;

    public Supplier() {
    }


    // Constructors, getters, setters, and other methods

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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", contactInfo=" + contactInfo + ", products=" + products
				+ "]";
	}


  
}
