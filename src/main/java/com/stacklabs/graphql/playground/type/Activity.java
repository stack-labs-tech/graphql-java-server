package com.stacklabs.graphql.playground.type;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Activity implements Serializable{
    private Date date;
    private String description;
    private String comment;
    private Category category;
}
