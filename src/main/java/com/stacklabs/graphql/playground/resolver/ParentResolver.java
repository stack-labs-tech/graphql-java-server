package com.stacklabs.graphql.playground.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.stacklabs.graphql.playground.dao.ParentDao;
import com.stacklabs.graphql.playground.type.Parent;

public class ParentResolver implements GraphQLResolver<Parent> {

    private ParentDao parentDao;

    public ParentResolver(ParentDao parentDao) {
        this.parentDao = parentDao;
    }
}
