package com.example.jparelationships.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(exclude = "publishers")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)

    @JoinTable(name = "book_publisher",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    )
    private Set<Publisher> publishers;

    public Book(String name, Publisher... publishers) {
        this.name = name;
        this.publishers = Stream.of(publishers).collect(Collectors.toSet());
        this.publishers.forEach(x -> x.getBooks().add(this));
    }

}
