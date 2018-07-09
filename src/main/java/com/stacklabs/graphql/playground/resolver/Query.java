package com.stacklabs.graphql.playground.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.stacklabs.graphql.playground.dao.NannyDao;
import com.stacklabs.graphql.playground.dao.ParentDao;
import com.stacklabs.graphql.playground.type.Nanny;
import com.stacklabs.graphql.playground.type.Parent;

import java.util.Optional;

public class Query implements GraphQLQueryResolver {

    private ParentDao parentDao;
    private NannyDao nannyDao;

    public Query(ParentDao parentDao, NannyDao nannyDao) {
        this.parentDao = parentDao;
        this.nannyDao = nannyDao;
    }

    public Iterable<Parent> parents() {
        return parentDao.getParents();
    }

    public Iterable<Nanny> nannies() {
        return nannyDao.getNannies();
    }

    public Optional<Parent> parentById(Long id) {
        return parentDao.getParent(id);
    }

    public Optional<Parent> parent(Long id, Boolean withBabies) {
        return parentDao.getParent(id);
    }

    public Optional<Nanny> nannyById(Long id) {
        return nannyDao.getNanny(id);
    }

    public Optional<Nanny> nanny(Long id, Boolean withBabies) {
        return nannyDao.getNanny(id);
    }
}
