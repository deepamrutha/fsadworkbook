package com.skill2.main;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.skill2.entity.Product;

public class App {
    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // CREATE
        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 5);
        Product p2 = new Product("Mouse", "Wireless Mouse", 1200, 20);
        session.save(p1);
        session.save(p2);

        // READ
        Product product = session.get(Product.class, 1);
        System.out.println(product.getName());

        // UPDATE
        product.setPrice(70000);
        session.update(product);

        // DELETE
        Product deleteProduct = session.get(Product.class, 2);
        session.delete(deleteProduct);

        tx.commit();
        session.close();
        factory.close();
    }
}
