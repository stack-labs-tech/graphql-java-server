package com.stacklabs.graphql.playground.type;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Baby implements Serializable {
    private Long id;
    private String firstname;
    private String lastname;
    private List<Activity> activities;
}
