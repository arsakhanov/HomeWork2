package ru.arsakhanov;

public class MyHashMap {

    //todo удаление элемента DONE

    private int capacity;
    public Entry[] buckets;
    private int size = 0;
    private final double percent = 0.75;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[this.capacity];
    }

    /**
     * метод добавляет ключ-значение в мапу
     * ключ-значение может быть любого типа
     *
     * @param key   объект любого типа, которую можно указать как ключ
     * @param value объект любого типа, значение ключа
     */
    public void put(Object key, Object value) {
        if (size == percent * capacity) {
            Entry[] oldBuckets = buckets;
            capacity *= 2;
            size = 0;
            buckets = new Entry[capacity];
            for (Entry e : oldBuckets) {
                while (e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
        }
        Entry entry = new Entry(key, value, null);
        int index = getIndex(key);

        Entry current = buckets[index];
        if (current == null) {
            buckets[index] = entry;
            size++;
        } else {
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = entry;
                size++;
            }
        }
    }

    /**
     * метод который получает объект из мапы по ключу
     * если такого объекта нет - возвращает null
     *
     * @param key объект любого типа
     * @return возвращает key, если удается его найти в мапе и null в противном случае
     */
    public Object get(Object key) {
        Entry bucket = buckets[getIndex(key)];
        while (bucket != null) {
            if (getHash(key) == getHash(bucket.key)) {
                if (key.equals(bucket.key)) {
                    return bucket.getValue();
                }
            }
            bucket = bucket.next;
        }
        return null;
    }

    /**
     * проверяет есть ли данный key в мапе
     *
     * @param key объект любого типа
     * @return возвращает true, в противном случае - false
     */
    public boolean contains(Object key) {
        Entry bucket = buckets[getIndex(key)];
        while (bucket != null) {
            if (getHash(key) == getHash(bucket.key)) {
                if (key.equals(bucket.key)) {
                    return true;
                } else bucket = bucket.next;
            }
        }
        return false;
    }

    /**
     * Удаляет элемент из мапы, если он в нем существует
     *
     * @param key объект любого типа
     * @return возвращает true, если удление прошло успешно и false - в противном случае
     */
    public boolean remove(Object key) {
        Entry previous = null;
        Entry current = buckets[getIndex(key)];
        if (current == null) {
            return false;
        }
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous != null) {
                    previous.next = current.next;

                } else {
                    buckets[getIndex(key)] = null;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }


    /**
     * вычисляет хэш ключ, потому проделывает операцию
     * поразрядного сложения с размером buckets
     *
     * @param key объект любого типа
     * @return возвращает индекс по форм
     */
    public int getIndex(Object key) {
        return getHash(key) & getBucketsSize() - 1;
    }

    /**
     * возвращает размер массива buckets
     *
     * @return возвращает размер массива типа int
     */
    public int getBucketsSize() {
        return buckets.length;
    }

    /**
     * @return возвращает количество элементов мапы
     */
    public int getSize() {
        return size;
    }

    /**
     * проверяем пустая ли мапа или нет
     *
     * @return возвращает true, если в мапе нет элементов
     * и false в противном случае
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * возвращает хеш объекта
     *
     * @param key объект любого типа
     * @return возвращает null, если объект равен null, в противном случае хэшкод объекта
     */
    public int getHash(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : buckets) {
            while (entry != null) {
                sb.append(entry);
                if (entry.next != null) {
                    sb.append(", ");
                }
                entry = entry.next;
            }
        }
        return sb.toString();
    }
}

