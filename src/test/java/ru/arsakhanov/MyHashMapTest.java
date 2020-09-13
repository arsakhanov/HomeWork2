package ru.arsakhanov;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MyHashMapTest {
    private MyHashMap map;

    //убедимся, действительно ли isEmpty возвращает true, если мапа пустая
    @Test
    void testIsEmpty(){
        this.map = new MyHashMap();
        Assert.assertTrue(map.isEmpty());
    }

    //убедимся, действительно ли isEmpty возвращает false, если мапа заполнена
    @Test
    void testIsEmptyFlase(){
        this.map = new MyHashMap();
        map.put("Japan", "Tokyo");
        Assert.assertFalse(map.isEmpty());
    }

    //убедимся, действительно ли метод put добавляет ключ-значение в мапу
    @Test
    void testPut() {
        this.map = new MyHashMap();
        map.put("Russia", "Moscow");
        map.put("England", "London");
        Object actual = map.get("Russia");
        Assert.assertEquals("Moscow", actual);
        actual = map.get("England");
        Assert.assertEquals("London", actual);
    }

    //Убедимся, не перепишет ли put ключи с одинаковым хешом
    @Test
    void testDoesNotOverwriteSeparateKeysWithSameHash() {
        this.map = new MyHashMap();
        map.put("Ea", 5);
        map.put("FB", 10);
        Assert.assertEquals(5,map.get("Ea"));
        Assert.assertEquals(10,map.get("FB"));
    }


    //убедимся возвращает ли ключ правильное значение
    @Test
    void testGetCorrectValue() {
        this.map = new MyHashMap();
        map.put("Russia", "Moscow");
        Assert.assertEquals("Moscow",map.get("Russia"));
    }

    //убедимся, действительно ли contains возвращает true, если ключ существует в мапе
    @Test
    void testIsContainsKey() {
        this.map = new MyHashMap();
        map.put("Russia", "Moscow");
        map.put("England", "London");
        Assert.assertTrue(map.contains("Russia"));
    }

    //убедимся, действительно ли contains возвращает false, если ключа нет в мапе
    @Test
    void testIsContainsKeyFalse() {
        this.map = new MyHashMap();
        map.put("Russia", "Moscow");
        Assert.assertFalse(map.contains("Japan"));
    }

    //Убедимся, что contains покажет false для новой мапы
    @Test
    void testIsContainsKeyForNewMap() {
        this.map = new MyHashMap();
        Assert.assertFalse(map.contains("Japan"));
    }

    //Убедимся, что contains покажет false разных ключе с одинаковым хешом
    @Test
    void testIsContainsFalseForDifferentKeysWhithSameHash() {
        this.map = new MyHashMap();
        map.put("Ea", 10);
        Assert.assertFalse(map.contains("FB"));
    }

    //убедимся, действительно ли remove удаляет именно тот объект, который мы указали
    @Test
    void testRemoveIsTrue() {
        this.map = new MyHashMap();
        map.put("Russia", "Moscow");
        map.put("Japan", "Tokyo");
        map.remove("Russia");
        Assert.assertFalse(map.contains("Russia"));
        Assert.assertTrue(map.contains("Japan"));
    }

    //Убедимся, что для новой мапы remove не покажет отрицательное число
    @Test
    void testRemoveDoesNotEffectNewMap() {
        this.map = new MyHashMap();
        map.remove("Russia");
        Assert.assertEquals(0,map.getSize());

    }

    //Убедимся, действительно ли remove уменьшает размер мапы при удалении элемента
    @Test
    void testRemove() {
        this.map = new MyHashMap();
        map.put("Russia", "Moscow");
        map.put("Japan", "Tokyo");
        map.remove("Russia");
        Assert.assertEquals(1, map.getSize());
        map.remove("Japan");
        Assert.assertEquals(0, map.getSize());
    }

    //Убедимся, действительно ли getSize возвращает правильное значение
    @Test
    void testGetSize() {
        this.map = new MyHashMap();
        map.put("Russia", "Moscow");
        Assert.assertEquals(1, map.getSize());
        map.put("England", "London");
        Assert.assertEquals(2, map.getSize());
    }

    //Убедимся, действительно ли getSize возвращает 0, если мапа пустая
    @Test
    void testGetSizeIfMapIsEmpty() {
        this.map = new MyHashMap();
        Assert.assertEquals(0, map.getSize());
    }


}