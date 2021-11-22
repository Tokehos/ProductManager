package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];

        Product[] items = repo.findAll();

        for (Product item : items) {
            if (matches(item, text)) {
                int lenght = result.length+1;
                Product[] tmp = new Product[lenght];
                System.arraycopy(result,0, tmp,0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
                lenght++;
            }
        }
        return result;
    }

    public boolean matches(Product item, String search) {
        if (item.getName().contains(search)) {
            return true;
        }

        if (item instanceof Book) {
            Book book = (Book) item;
            if (book.getAuthor().contains(search)) {
                return true;
            }
        }
        if (item instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) item;
            if (smartphone.getProducter().contains(search)) {
                return true;
            }
        }
        return false;
    }
}
