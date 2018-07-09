package com.stacklabs.graphql.playground.dao;

import com.stacklabs.graphql.playground.type.Activity;
import com.stacklabs.graphql.playground.type.Baby;
import com.stacklabs.graphql.playground.type.Category;
import com.stacklabs.graphql.playground.type.Parent;
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
public class ParentDao {
    public List<Parent> parents = new ArrayList<>();

    public Optional<Parent> getParent(Long id) {
        return parents.stream().filter(parent -> id.compareTo(parent.getId()) == 0).findFirst();
    }

    public Long save(Parent parent) {
        Long id = Long.valueOf(parents.size()+1);
        parent.setId(id);
        parents.add(parent);
        return id;
    }

    public void delete(Long id) {
        parents.remove(id);
    }

    @PostConstruct
    public void buildParents() {

        Parent parentMaxwellFran = new Parent();
        parentMaxwellFran.setId(1l);
        parentMaxwellFran.setFirstnameParent1("Maxwell");
        parentMaxwellFran.setFirstnameParent2("Fran");
        parentMaxwellFran.setLastnameParent1("Sheffield");
        parentMaxwellFran.setLastnameParent2("Fine");
        parentMaxwellFran.setAddress("1 rue du Capitole, 31000 Toulouse");

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

        parentMaxwellFran.setBabies(new ArrayList<Baby>() {
            {
                add(babyMaggie);
                add(babyBrighton);
            }
        });

        parents.add(parentMaxwellFran);
    }
}
