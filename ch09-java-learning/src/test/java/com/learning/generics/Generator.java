package com.learning.generics;

import java.util.Collection;

public interface Generator<E> {
    public E next();

    <T> boolean containsAll(Collection<T> c);
    <T extends E> boolean addAll(Collection<T> c);
}


