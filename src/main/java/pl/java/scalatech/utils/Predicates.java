package pl.java.scalatech.utils;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Predicates {

    public static <T> Predicate<T> or(Predicate<T>... predicates) {
        return Stream.of(predicates).reduce(Predicate::or).get();
    }

    public static <T> Predicate<T> and(Predicate<T>... predicates) {
        return Stream.of(predicates).reduce(Predicate::and).get();
    }

}
