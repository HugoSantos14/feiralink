package com.hugosantos.feiralink.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
public class Client extends User {

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private final List<Order> orders = new ArrayList<>();

    public Client() {
        super();
    }

    public Client(Long id, String name, String email, String phone, String password) {
        super(id, name, email, phone, password);
    }
}
