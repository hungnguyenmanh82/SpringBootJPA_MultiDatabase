package com.example.demo.entity1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "Publishers")
public class Publisher implements Serializable {
 
    private static final long serialVersionUID = 746237126088051312L;
 
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;
 
    @Column(name = "Name", length = 255, nullable = false)
    private String name;
 
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
 
}
