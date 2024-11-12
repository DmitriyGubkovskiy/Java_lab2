package ru.spbstu.telematics.java;


import java.util.*;

public class MyHashMap<K, V> implements Map<K, V>, Iterable<Map.Entry<K, V>>{


    static class Node<K, V> implements Map.Entry<K, V>{

        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;

        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V new_value){
            V tmp = this.value;
            this.value = new_value;
            return tmp;
        }

        @Override
        public String toString(){
            return key + ": " + value;
        }

        @Override
        public int hashCode(){
            return  Objects.hashCode(this.key) +  Objects.hashCode(this.value);
        }

        @Override
        public boolean equals(Object obj){
            if(obj == this){
                return true;
            }

            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            return Objects.equals(this.key, ((Node<?, ?>) obj).getKey())
                    && Objects.equals(this.value, ((Node<?, ?>) obj).getValue());
        }

    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator(){
        Iterator<Map.Entry<K, V>> it = new Iterator<Map.Entry<K, V>>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < data.size();
            }

            @Override
            public Node<K, V> next() {
                return data.get(currentIndex++);
            }

            @Override
            public void remove() {
                data.remove(currentIndex);
            }
        };
        return it;
    }


    private final ArrayList<Node<K, V>> data;

    public MyHashMap(){
        data = new ArrayList<Node<K, V>>();
    }

    public MyHashMap(K key, V value){
        data = new ArrayList<Node<K, V>>();
        this.put(key, value);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        for(Node<K, V> x: data){
            if(x.getKey() == key){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(Node<K, V> x: data){
            if(x.getValue() == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for(Node<K, V> x: data){
            if(x.getKey() == key){
                return x.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {

        for(Node<K, V> x: data){
            if(x.getKey() == key){
                return x.setValue(value);
            }
        }
        Node<K, V> e = new Node<K, V>(key, value);
        data.add(e);
        return value;
    }

    @Override
    public V remove(Object key) {
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getKey() == key){
                return data.remove(i).getValue();
            }
        }
        return null;
    }

    @Override
    public void putAll(Map m) {
        Set<Map.Entry<K, V>> entries =  m.entrySet();
        for(Map.Entry<K, V> x : entries){
            this.put(x.getKey(), x.getValue());
        }
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Set keySet() {
        HashSet<K> keys = new HashSet<K>();
        for(Node<K, V> x: data){
            keys.add(x.getKey());
        }
        return keys;
    }

    @Override
    public Collection values() {
        ArrayList<V> values = new ArrayList<V>();
        for(Node<K, V> x: data){
            values.add(x.getValue());
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        HashSet<Map.Entry<K, V>> entries = new HashSet<Map.Entry<K, V>>();
        for(Node<K, V> x: data){
            entries.add(x);
        }
        return entries;
    }

    @Override
    public int hashCode(){
        return  Objects.hashCode(this.data);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return Objects.equals(this.data, ((MyHashMap<?, ?>) obj).data);
    }


}
