package com.example.application.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/*@EqualsAndHashCode(callSuper = true)*/
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Author extends AbstractModel {
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("authors")
    private Set<Book> books;
}
