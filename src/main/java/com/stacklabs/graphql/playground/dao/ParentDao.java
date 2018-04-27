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
    private List<Parent> parents = new ArrayList<>();

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

        Parent parentNoaZohra = new Parent();
        parentNoaZohra.setId(1l);
        parentNoaZohra.setFirstnameParent1("Noa");
        parentNoaZohra.setFirstnameParent2("Zohra");
        parentNoaZohra.setLastnameParent1("Adams");
        parentNoaZohra.setLastnameParent2("Adams");

        Baby babyJacque = new Baby();
        babyJacque.setId(1l);
        babyJacque.setFirstname("Jacque");
        babyJacque.setLastname("Adams");

        Activity activityJacqueCamera = new Activity();
        activityJacqueCamera.setCategory(Category.CAMERA);
        activityJacqueCamera.setDate(new Date());
        activityJacqueCamera.setDescription("Take a photo");

        Activity activityJacqueSleep = new Activity();
        activityJacqueSleep.setCategory(Category.SLEEP);
        activityJacqueSleep.setDate(new Date());
        activityJacqueSleep.setDescription("Sleeping");

        babyJacque.setActivities(new ArrayList<Activity>() {
            {
                add(activityJacqueCamera);
                add(activityJacqueSleep);
            }
        });

        Baby babyMichel = new Baby();
        babyMichel.setId(2l);
        babyMichel.setFirstname("Michelle");
        babyMichel.setLastname("Adams");

        Activity activityMichelChange = new Activity();
        activityMichelChange.setCategory(Category.CHANGE);
        activityMichelChange.setDate(new Date());
        activityMichelChange.setDescription("Change your baby's diaper");

        Activity activityMichelCare = new Activity();
        activityMichelCare.setCategory(Category.CARE);
        activityMichelCare.setDate(new Date());
        activityMichelCare.setDescription("Syringe");

        babyMichel.setActivities(new ArrayList<Activity>() {
            {
                add(activityMichelChange);
                add(activityMichelCare);
            }
        });

        parentNoaZohra.setBabies(new ArrayList<Baby>() {
            {
                add(babyJacque);
                add(babyMichel);
            }
        });

        parents.add(parentNoaZohra);
    }
}
