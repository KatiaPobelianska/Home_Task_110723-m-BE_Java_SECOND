package home_task_23_11_28.task_2.itemsInventory;

import home_task_23_11_28.task_2.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemsInventory {
    public static void main(String[] args) {
        // Создаем объекты товаров
        Item item1 = new Item("Ware1", 23.45);
        Item item2 = new Item("Ware2", 65.90);
        Item item3 = new Item("Ware3", 18.6);
        Item item4 = new Item("Ware4", 50.75);
        Item item5 = new Item("Ware5", 26.5);

        // Создаем мапу для хранения товара и его количество
        Map<Item, Integer> itemsInventory = new HashMap<>();
        itemsInventory.put(item1, 5);
        itemsInventory.put(item2, 1);
        itemsInventory.put(item3, 4);
        itemsInventory.put(item4, 2);
        itemsInventory.put(item5, 3);

        // Используем метод forEach для вывода товаров
        itemsInventory.forEach((item, quantity) -> {
            if (quantity < 3)
                System.out.println("Товар " + item.getName() + " к-во " + quantity + " стоимость " + item.getCost());
        });
    }
}
