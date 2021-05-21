package com.example.application.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
public class BookPublisher extends Abstract{


    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("bookPublishers")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonIgnoreProperties("bookPublishers")
    private Publisher publisher;

    private Date publisherDate;
}
