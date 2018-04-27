package com.stacklabs.graphql.playground.dao;

import com.stacklabs.graphql.playground.type.Nanny;
import com.stacklabs.graphql.playground.type.Parent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Component
public class NannyDao {
    private List<Nanny> nannies = new ArrayList<>();

    public Optional<Nanny> getNanny(Long id) {
        return nannies.stream().filter(nanny -> id.compareTo(nanny.getId()) == 0).findFirst();
    }

    public Long save(Nanny nanny) {
        Long id = Long.valueOf(nannies.size()+1);
        nanny.setId(id);
        nannies.add(nanny);
        return id;
    }

    public void delete(Long id) {
        nannies.remove(id);
    }

    @PostConstruct
    public void buildParents() {
        Nanny superNanny = new Nanny();
        superNanny.setFirstname("Mathilde");
        superNanny.setLastname("Vuge");
        superNanny.setId(1l);
        superNanny.setBabiesId(new ArrayList<Long>() {
            {
                add(1l);
                add(2l);
            }
        });
        nannies.add(superNanny);
    }
}
