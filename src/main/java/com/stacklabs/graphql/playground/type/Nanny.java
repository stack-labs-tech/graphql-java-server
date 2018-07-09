package com.stacklabs.graphql.playground.type;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Nanny implements Serializable {
    private Long id;
    private List<Baby> babies;
    private String firstname;
    private String lastname;
    private String address;
}
