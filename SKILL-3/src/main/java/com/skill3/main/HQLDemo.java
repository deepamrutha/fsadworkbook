package com.skill3.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.skill3.entity.Product;
import com.skill3.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // 1. Sort by price ASC
        Query<Product> q1 = session.createQuery(
                "FROM Product p ORDER BY p.price ASC", Product.class);
        System.out.println("\n--- Price Ascending ---");
        q1.list().forEach(p ->
                System.out.println(p.getName() + " : " + p.getPrice()));

        // 2. Sort by price DESC
        Query<Product> q2 = session.createQuery(
                "FROM Product p ORDER BY p.price DESC", Product.class);
        System.out.println("\n--- Price Descending ---");
        q2.list().forEach(p ->
                System.out.println(p.getName() + " : " + p.getPrice()));

        // 3. Sort by quantity (highest first)
        Query<Product> q3 = session.createQuery(
                "FROM Product p ORDER BY p.quantity DESC", Product.class);
        System.out.println("\n--- Quantity High to Low ---");
        q3.list().forEach(p ->
                System.out.println(p.getName() + " : " + p.getQuantity()));

        // 4. Pagination – first 3 products
        Query<Product> q4 = session.createQuery("FROM Product", Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);
        System.out.println("\n--- First 3 Products ---");
        q4.list().forEach(p -> System.out.println(p.getName()));

        // 5. Pagination – next 3 products
        Query<Product> q5 = session.createQuery("FROM Product", Product.class);
        q5.setFirstResult(3);
        q5.setMaxResults(3);
        System.out.println("\n--- Next 3 Products ---");
        q5.list().forEach(p -> System.out.println(p.getName()));

        // 6. Aggregate – total count
        Query<Long> q6 = session.createQuery(
                "SELECT COUNT(p.id) FROM Product p", Long.class);
        System.out.println("\nTotal Products: " + q6.uniqueResult());

        // 7. Aggregate – quantity > 0
        Query<Long> q7 = session.createQuery(
                "SELECT COUNT(p.id) FROM Product p WHERE p.quantity > 0", Long.class);
        System.out.println("Products with quantity > 0: " + q7.uniqueResult());

        // 8. Min & Max price
        Query<Object[]> q8 = session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p", Object[].class);
        Object[] result = q8.uniqueResult();
        System.out.println("Min Price: " + result[0]);
        System.out.println("Max Price: " + result[1]);

        // 9. GROUP BY description
        Query<Object[]> q9 = session.createQuery(
                "SELECT p.description, COUNT(p.id) FROM Product p GROUP BY p.description",
                Object[].class);
        System.out.println("\n--- Group By Description ---");
        for (Object[] row : q9.list()) {
            System.out.println(row[0] + " -> " + row[1]);
        }

        // 10. LIKE examples
        Query<Product> q10 = session.createQuery(
                "FROM Product p WHERE p.name LIKE 'A%'", Product.class);
        System.out.println("\nNames starting with A:");
        q10.list().forEach(p -> System.out.println(p.getName()));

        tx.commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
