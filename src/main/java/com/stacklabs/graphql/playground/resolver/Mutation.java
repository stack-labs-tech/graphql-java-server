package com.stacklabs.graphql.playground.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.stacklabs.graphql.playground.dao.NannyDao;
import com.stacklabs.graphql.playground.dao.ParentDao;
import com.stacklabs.graphql.playground.type.Nanny;
import com.stacklabs.graphql.playground.type.Parent;

public class Mutation implements GraphQLMutationResolver {

    private ParentDao parentDao;
    private NannyDao nannyDao;

    public Mutation(ParentDao parentDao, NannyDao nannyDao) {
        this.parentDao = parentDao;
        this.nannyDao = nannyDao;
    }

    public Long saveParent(Parent parent) {
       return parentDao.save(parent);
    }

    public void deleteParent(Long id) {
        parentDao.delete(id);
    }

    public Long saveNanny(Nanny nanny) {
       return nannyDao.save(nanny);
    }

    public void deleteNanny(Long id) {
        nannyDao.delete(id);
    }
}
