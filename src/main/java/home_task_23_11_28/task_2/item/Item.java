package home_task_23_11_28.task_2.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*2 Создайте класс Item с полями названия товара и стоимости товара.
Создайте мапу, хранящую товар и соответствующее ему число единиц товара.
С помощью метода forEach получите все товары, у которых осталось меньше 3 штук.*/
@Getter
@AllArgsConstructor
public class Item {
    private String name;
    private double cost;
}
