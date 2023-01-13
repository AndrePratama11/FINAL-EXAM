/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B.FinalExam;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andre Pratama ONG 20200140075
 */
@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    Person myperson = new Person();
    PersonJpaController ctrl = new PersonJpaController();
    
    @GetMapping("/{id}")
    public List<Person> getNameById(@PathVariable("id") int id) {
        List<Person> dummy = new ArrayList<>();
        try {
            myperson = ctrl.findPerson(id);
            dummy.add(myperson);
        } catch (Exception e) {
            dummy = List.of();
        }
        return dummy;
    }
    
    @GetMapping
    public List<Person> getAll() {
        List<Person> dummy = new ArrayList<>();
        try {
            dummy = ctrl.findPersonEntities();
        } catch (Exception e) {
            dummy = List.of();
        }
        return dummy;
    }
    
    @PostMapping
    public String createPerson (HttpEntity<String> data) {
        String message = "";
        
        try {
            String json_receive = data.getBody();

            ObjectMapper map = new ObjectMapper();

            Person person = new Person();

            person = map.readValue(json_receive, Person.class);

            ctrl.create(person);
            message = " Data Tersimpan...";

        } catch (Exception e) {
            message = "Gagal menyimpan..";
        }

        return message;
    }
    
    @PutMapping()
    public String editPerson(HttpEntity<String> upd) {
        String message = "no action";
        try {
            String json_receive = upd.getBody();
            ObjectMapper mapper = new ObjectMapper();

            Person update = new Person();

            update = mapper.readValue(json_receive, Person.class);
            ctrl.edit(update);
            message = "Data Telah Terupdate...";
        } catch (Exception e) {
        }
        return message;
    }
    
    @DeleteMapping()
    public String deletePerson(HttpEntity<String> del) {
        String message = "no action";
        try {
            String json_receive = del.getBody();
            ObjectMapper mapper = new ObjectMapper();

            Person delete = new Person();

            delete = mapper.readValue(json_receive, Person.class);
            ctrl.destroy(delete.getId());

            message = "Data telah terhapus...";
        } catch (Exception e) {
        }
        return message;
    }
}
