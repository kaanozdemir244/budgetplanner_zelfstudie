package be.pxl.student.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name="label.getAll", query = "SELECT l FROM Label as l")
@NamedQuery(name="label.getByName", query = "SELECT l FROM Label l WHERE l.name= :name")
@Table(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
