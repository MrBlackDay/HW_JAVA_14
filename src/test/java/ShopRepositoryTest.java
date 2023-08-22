import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveTrueIdProduct() {
        ShopRepository repo = new ShopRepository();
        Product productOne = new Product(1, "молоко", 40);
        Product productTwo = new Product(2, "кефир", 25);
        Product productThree = new Product(3, "сметана", 80);

        repo.add(productOne);
        repo.add(productTwo);
        repo.add(productThree);
        repo.remove(1);

        Product[] actual = repo.findAll();
        Product[] excepted = {productTwo, productThree};
        Assertions.assertArrayEquals(actual, excepted);
    }

    @Test
    public void testRemoveFalseIdProduct() {
        ShopRepository repo = new ShopRepository();
        Product productOne = new Product(1, "молоко", 40);
        Product productTwo = new Product(2, "кефир", 25);
        Product productThree = new Product(3, "сметана", 80);

        repo.add(productOne);
        repo.add(productTwo);
        repo.add(productThree);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(0));
    }

}