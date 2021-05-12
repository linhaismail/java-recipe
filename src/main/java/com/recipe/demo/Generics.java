package com.recipe.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 泛型的使用
 * 
 * @author LinHai
 * @date 2020-11-03 14:03
 */
public class Generics {

    private static <K, E> Map<K, List<E>> groupByKey(List<E> data, Function<? super E, ? extends K> generator) {
        Map<K, List<E>> map = new HashMap<>(data.size());
        for (E e : data) {
            K key = generator.apply(e);
            List<E> es = map.computeIfAbsent(key, k -> new ArrayList<>());
            es.add(e);
        }
        Set<Map.Entry<K, List<E>>> entries = map.entrySet();
        return map;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    private static class Employee {
        private String name;
        private int age;
        private char gender;
    }

    public static void main(String[] args) {
        List<Employee> es = Arrays.asList(new Employee("旺财", 17, 'M'),
                new Employee("狗剩", 18, 'F'),
                new Employee("小强", 17, 'F'));
        Map<Integer, List<Employee>> map = groupByKey(es, Employee::getAge);
        System.out.println(map);
        IntStream.range(1, 7).forEach(System.out::println);
        LongStream.rangeClosed(1, 7).forEach(System.out::println);
    }
}
