package com.stacklabs.graphql.playground.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.stacklabs.graphql.playground.dao.NannyDao;
import com.stacklabs.graphql.playground.type.Nanny;

import java.util.Optional;

public class NannyResolver implements GraphQLResolver<Nanny> {

    private NannyDao nannyDao;

    public NannyResolver(NannyDao nannyDao) {
        this.nannyDao = nannyDao;
    }

    public Optional<Nanny> getNanny(Long id) {
        return nannyDao.getNanny(id);
    }
}
