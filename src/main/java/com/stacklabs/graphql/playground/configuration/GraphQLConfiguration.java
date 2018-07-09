package com.stacklabs.graphql.playground.configuration;

import com.stacklabs.graphql.playground.dao.NannyDao;
import com.stacklabs.graphql.playground.dao.ParentDao;
import com.stacklabs.graphql.playground.exception.GraphQLErrorAdapter;
import com.stacklabs.graphql.playground.resolver.Mutation;
import com.stacklabs.graphql.playground.resolver.Query;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class GraphQLConfiguration {

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }

    @Bean
    public Query query(ParentDao parentDao, NannyDao nannyDao) {
        return new Query(parentDao, nannyDao);
    }

    @Bean
    public Mutation mutation(ParentDao parentDao, NannyDao nannyDao) {
        return new Mutation(parentDao, nannyDao);
    }
}
