package ru.arsakhanov;


public class Entry {
    final Object key;
    Object value;
    Entry next;


    public Entry(Object key, Object value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Entry getNext() {
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            return key.equals(entry.getKey()) &&
                    value.equals(entry.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
        hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return '{' +"key=" + getKey() +
                ", value=" + getValue() +
                '}' + '\n';
    }
}


