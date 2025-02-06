package com.microcamp.db.dto;


import java.time.Instant;

public class CustomerDto {


    private Long id;


    private String name;

    private String uniqueKey;

    private Instant dateBirth;

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

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public Instant getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Instant dateBirth) {
        this.dateBirth = dateBirth;
    }
}
