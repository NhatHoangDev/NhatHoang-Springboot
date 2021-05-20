package com.example.application.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class BookPublisher extends AbstractModel {
    @ManyToOne
    @JoinColumn(name = "books_id")
    @JsonIgnoreProperties("bookPublishers")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonIgnoreProperties("bookPublishers")
    private Publisher publisher;
    private Date publisherDate;
}
