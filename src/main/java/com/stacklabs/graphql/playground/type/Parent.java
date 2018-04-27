package com.stacklabs.graphql.playground.type;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Parent implements Serializable {
    private Long id;
    private String firstnameParent1;
    private String firstnameParent2;
    private String lastnameParent1;
    private String lastnameParent2;
    private List<Baby> babies;
}
