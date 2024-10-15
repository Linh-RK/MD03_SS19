package com.ra.book.model.dao.Book;

import com.ra.book.model.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Book> findAll() {
        try(Session session = sessionFactory.openSession();) {
            return session.createQuery("from Book",Book.class).list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean create(Book book) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Book findById(int id) {
        try(Session session = sessionFactory.openSession();) {
            return session.get(Book.class, id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(Book book) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(session.get(Book.class, id));
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}
