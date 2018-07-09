package com.stacklabs.graphql.playground.dao;

import com.stacklabs.graphql.playground.type.Nanny;
import com.stacklabs.graphql.playground.type.Parent;
import com.stacklabs.graphql.playground.type.Activity;
import com.stacklabs.graphql.playground.type.Baby;
import com.stacklabs.graphql.playground.type.Category;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
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
        superNanny.setFirstname("Euphegenia");
        superNanny.setLastname("Doubtfire");
        superNanny.setId(1l);
 
        Baby babyMaggie = new Baby();
        babyMaggie.setId(1l);
        babyMaggie.setFirstname("Maggie");
        babyMaggie.setLastname("Sheffield");

        Activity activityMaggieCamera = new Activity();
        activityMaggieCamera.setCategory(Category.FEED);
        activityMaggieCamera.setDate(new Date());
        activityMaggieCamera.setDescription("Eating");

        Activity activityMaggieSleep = new Activity();
        activityMaggieSleep.setCategory(Category.SLEEP);
        activityMaggieSleep.setDate(new Date());
        activityMaggieSleep.setDescription("Sleeping");

        babyMaggie.setActivities(new ArrayList<Activity>() {
            {
                add(activityMaggieCamera);
                add(activityMaggieSleep);
            }
        });

        Baby babyBrighton = new Baby();
        babyBrighton.setId(2l);
        babyBrighton.setFirstname("Brighton");
        babyBrighton.setLastname("Sheffield");

        Activity activityBrightonChange = new Activity();
        activityBrightonChange.setCategory(Category.CHANGE);
        activityBrightonChange.setDate(new Date());
        activityBrightonChange.setDescription("Change your baby's diaper");

        Activity activityBrightonCare = new Activity();
        activityBrightonCare.setCategory(Category.CARE);
        activityBrightonCare.setDate(new Date());
        activityBrightonCare.setDescription("Syringe");

        babyBrighton.setActivities(new ArrayList<Activity>() {
            {
                add(activityBrightonChange);
                add(activityBrightonCare);
            }
        });

        superNanny.setBabies(new ArrayList<Baby>() {
            {
                add(babyMaggie);
                add(babyBrighton);
            }
        });

        nannies.add(superNanny);
    }

    
}
