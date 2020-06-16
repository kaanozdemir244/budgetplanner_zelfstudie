package be.pxl.student.DAO.impli;

import be.pxl.student.DAO.ILabelDao;
import be.pxl.student.entity.Label;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class LabelDao implements ILabelDao {
    private EntityManager entityManager;

    public LabelDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Label> getAll() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery typedQuery = entityManager.createQuery("label.getAll",
                Label.class);
        transaction.commit();
        return typedQuery.getResultList();
    }

    @Override
    public Label getById(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        var label = entityManager.find(Label.class, id);
        transaction.commit();
        return label;
    }

    @Override
    public Label getByName(String name) {
        Label label = new Label();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery typedQuery = entityManager.createQuery("label.getByName",Label.class);
        typedQuery.setParameter("name",name.toLowerCase());
        try {
            label = (Label) typedQuery.getSingleResult();
        } catch (NoResultException e) {
            label = null;
        }
        transaction.commit();
       return label;
    }

    @Override
    public Label addLabel(Label label) {
        EntityTransaction transaction= entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(label);
        transaction.commit();
        return label;
    }

    @Override
    public boolean updateLabel(Label label) {
        EntityTransaction transaction= entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(label);
        transaction.commit();
        return true;
    }

    @Override
    public boolean deleteLabel(Label label) {
        EntityTransaction transaction= entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(label);
        transaction.commit();
        return true;
    }
}
