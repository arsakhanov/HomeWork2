package ru.arsakhanov;

/**
 * Класс для создания ноды, чтобы добавлять новые элементы в map
 */
public class Entry {
    final Object key;
    Object value;
    Entry next;

    //конструктор класса Entry
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

    /**
     * переопределеине equals
     * объекты равны только тогда, когда равны их ключи и значения
     *
     * @param obj объект с парой ключ-значение
     * @return возвращает true, если объекты равны и false в противном случае
     */
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

    /**
     * переопределение хэш кода
     *
     * @return возвращает хэш код
     */
    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
        hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
        return hash;
    }

    /**
     * переопределенный метод toString
     *
     * @return возвращает строку типа String
     */
    @Override
    public String toString() {
        return '{' + "key=" + getKey() +
                ", value=" + getValue() +
                '}' + '\n';
    }
}


