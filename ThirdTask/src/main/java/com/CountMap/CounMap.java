package com.CountMap;

import java.util.*;

public class CounMap<T> implements CountMap<T> {

    private List<T> list=new ArrayList<>();

    public  T get(int index) {
        return list.get(index);
    }



    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public int getCount(T t) {
        int i = 0;
        for (T o : list) {
            if (o.equals(t)) {
                i++;
            }
        }
        return i;
    }

    @Override
    public int remove(T t) {
        int count=getCount(t);
        while (list.contains(t)){
            list.remove(t);
        }
        return count;
    }

    @Override
    public int size() {
        HashSet<T> size=new HashSet<>(list);
        return size.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        CounMap<T> source1 = (CounMap<T>) source;
        Iterator<T> it = source1.list.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }

    }

    @Override
    public Map toMap() {
        Map<T, Integer> map = new HashMap<>();
        for (T o : list) {
            map.put(o,getCount(o));
        }
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        for (T o : list) {
            destination.put(o,getCount(o));
        }
    }
}

