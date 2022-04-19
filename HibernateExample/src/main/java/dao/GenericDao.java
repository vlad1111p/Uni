package dao;

import model.Account;
import model.Card;
import model.Employee;
import model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AccessType;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Properties;


public class GenericDao<T> {

    SessionFactory sessionFactory;

    public GenericDao()
    {
        Configuration configuration = new Configuration() ;
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernateExample?serverTimezone=UTC");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "carmen2019");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");//
        properties.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Card.class);
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Project.class);
        configuration.addAnnotatedClass(Employee.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public void add(T object)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
    }

    public void update(T object)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
    }

    public void delete(T object)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
    }

    public List<T> getAll(T object)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName());
        List<T>  results = query.getResultList();
        transaction.commit();
        return results;
    }

    public T findById(T object, int id)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where id=" + id +"");
        T result = (T) query.getSingleResult();
        transaction.commit();
        return result;

        /*
         List<T>  results = query.getResultList();
         return results.get(0);
         */
    }

    public List<T> findByColumn(T object, String column, String value)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where " + column + "='" + value + "'" );
        List<T>  results = query.getResultList();
        transaction.commit();
        return results;

    }
}
