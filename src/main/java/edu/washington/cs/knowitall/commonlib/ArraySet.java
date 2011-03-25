package edu.washington.cs.knowitall.commonlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<E> implements Set<E> {
    private static final long serialVersionUID = 6140942206075484195L;
    
    private final ArrayList<E> store;
    
    public ArraySet() {
        this.store = new ArrayList<E>();
    }
    
    public ArraySet(E[] array) {
        this.store = new ArrayList<E>(Arrays.asList(array));
    }
    
    public ArraySet(Set<? extends E> set) {
        this.store = new ArrayList<E>(set);
    }
    
    public ArraySet(Collection<? extends E> collection) {
        this.store = new ArrayList<E>(collection.size());
        this.addAll(collection);
    }
    
    @Override
    public boolean add(E item) {
        if (this.contains(item)) {
            return false;
        }
        else {
            store.add(item);
            return true;
        }
    }
    
    public E get(int index) {
        return store.get(index);
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (! (other instanceof ArraySet<?>)) {
            return false;
        }
        
        ArraySet<?> set = (ArraySet<?>) other;
        for (E item : this) {
            if (!set.contains(item)) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        for (E item : this) {
            hash += item.hashCode();
        }
        
        return hash;
    }

    @Override
    public int size() {
        return store.size();
    }

    @Override
    public boolean isEmpty() {
        return store.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return store.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return store.iterator();
    }

    @Override
    public Object[] toArray() {
        return store.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return store.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return store.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return store.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean all = true;
        for (E o : c) {
            if (!this.add(o)) {
                all = false;
            }
        }
        
        return all;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return store.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return store.removeAll(c);
    }

    @Override
    public void clear() {
        store.clear();
    }
}
