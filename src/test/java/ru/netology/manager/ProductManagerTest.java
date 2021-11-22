package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductManager manager = new ProductManager(new ProductRepository());
    private Book first = new Book (1, "Война и мир", 5000, "Лев Толстой. Издание 1");
    private Book second = new Book (2, "Война и мир", 7000, "Лев Толстой. Издание 2");
    private Book third = new Book (3, "Евгений Онегин", 2000, "Александр Пушкин");
    private Book fourth = new Book (4, "Сборник сказок", 2300, "Александр Пушкин");
    private Smartphone fifth = new Smartphone (5, "iphone 8", 27000, "Iphone");
    private Smartphone sixth = new Smartphone (6, "iphone 10", 40000, "Iphone");
    private Smartphone seventh = new Smartphone (7, "Mi 5", 7000, "Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }


    @Test
    public void shouldSearchByNameIfOneProduct() {
        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Сборник сказок");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shuildSearchByNameIfSeveralProduct() {
    Product[] expected = {first, second};
    Product [] actual = manager.searchBy("Война и мир");

    assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorIfOneProduct() {
        Product[] expected = {second};
        Product[] actual = manager.searchBy("Лев Толстой. Издание 2");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorIfSeveralProduct() {
        Product[] expected = {third, fourth};
        Product[] actual = manager.searchBy("Александр Пушкин");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerIfOneProduct() {
        Product[] expected = {seventh};
        Product[] actual = manager.searchBy("Xiaomi");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerIfSeveralProduct() {
        Product[] expected = {fifth, sixth};
        Product[] actual = manager.searchBy("Iphone");

        assertArrayEquals(expected, actual);
    }
}

