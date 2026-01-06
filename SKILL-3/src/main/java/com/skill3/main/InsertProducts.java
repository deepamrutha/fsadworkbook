package com.skill3.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skill3.entity.Product;
import com.skill3.util.HibernateUtil;

public class InsertProducts {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Mouse", "Electronics", 800, 50));
        session.save(new Product("Keyboard", "Electronics", 1500, 30));
        session.save(new Product("Monitor", "Electronics", 12000, 15));
        session.save(new Product("Chair", "Furniture", 5000, 10));
        session.save(new Product("Table", "Furniture", 8000, 5));
        session.save(new Product("Pen", "Stationery", 20, 200));
        session.save(new Product("Notebook", "Stationery", 60, 120));

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully");
    }
}
