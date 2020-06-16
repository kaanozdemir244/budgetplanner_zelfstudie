package be.pxl.student.DAO;

import be.pxl.student.entity.Label;

import java.util.List;

public interface ILabelDao { List<Label> getAll();
    Label getById(int id);
    Label getByName(String name);
    Label addLabel(Label label);
    boolean updateLabel(Label label);
    boolean deleteLabel(Label label);
}
