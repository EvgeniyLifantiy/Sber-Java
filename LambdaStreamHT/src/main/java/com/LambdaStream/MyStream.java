package com.LambdaStream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream<T>{

    private Stream stream;

    public MyStream(Stream<T> stream) {
        this.stream=stream;
    }

    public static <T> MyStream<T> of(List<T> list) {
            return new MyStream<>(list.stream());
        }

        public MyStream <T>filter(Predicate<? super T> predicate) {
            return new MyStream<>(stream.filter(predicate));
        }

        public <R> MyStream <R>transform(Function<? super T,? extends R> function) {
            return new MyStream<>(stream.map(function));
        }

        public <K,V> Map<K,V> toMap(Function<? super T, ? extends K> keyMapper,
                             Function<? super T, ? extends V> valueMapper) {
           return (Map<K, V>) stream.collect(Collectors.toMap(keyMapper,valueMapper));
        }

}
