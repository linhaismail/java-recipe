package com.recipe.demo;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * @author LinHai
 * @date 2020-11-03 11:32
 */
public class FlatMap {

    @Getter
    public static class Customer {
        private String name;
        private List<Order> orders = new ArrayList<Order>();

        public Customer(String name) {
            this.name = name;
        }

        public Customer addOrder(Order order) {
            this.orders.add(order);
            return this;
        }
    }

    @Getter
    @ToString
    public static class Order {
        private int id;

        public Order(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Customer jack = new Customer("Jack");
        Customer tom = new Customer("Tom");
        Customer vincent = new Customer("Vincent");

        jack.addOrder(new Order(1))
                .addOrder(new Order(2))
                .addOrder(new Order(3));
        tom.addOrder(new Order(4))
                .addOrder(new Order(5));

        List<Customer> customers = Arrays.asList(jack, tom, vincent);

        System.out.println("------");
        customers.stream().map(Customer::getName).forEach(System.out::println);

        System.out.println("------");
        customers.stream().map(c -> c.getOrders().stream()).forEach(System.out::println);

        System.out.println("------");
        customers.stream().flatMap(c -> c.getOrders().stream()).forEach(System.out::println);
    }
}
