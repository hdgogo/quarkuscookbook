package org.example.ch7.persistence.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class NewPersonRepository implements PanacheRepository<NewPerson> {

    public NewPerson findByName(String name){
        return find("name", name).firstResult();
    }


    public List<NewPerson> findAlive(){
        return list("status", Status.Alive);
    }

    public void deleteStefs(){
        delete("name","Stef");
    }
}


