package com.example.application.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@JsonIgnoreProperties("publisher")
public class Publisher extends AbstractModel {
    private String name;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<BookPublisher> bookPublishers = new HashSet<>();
}
