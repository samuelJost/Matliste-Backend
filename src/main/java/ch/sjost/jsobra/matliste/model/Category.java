package ch.sjost.jsobra.matliste.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
    private @Id
    @GeneratedValue
    Long id;

    @Getter
    @Setter
    private String description;
}
