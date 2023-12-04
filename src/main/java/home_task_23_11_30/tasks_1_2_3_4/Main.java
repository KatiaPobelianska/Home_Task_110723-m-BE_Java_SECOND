package home_task_23_11_30.tasks_1_2_3_4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Создайте класс Дом, содержащий список Квартир. Каждая квартира содержит список комнат.
 Каждая комната содержит площадь. Посчитайте суммарную жилую площадь дома.*/
public class Main {
    public static void main(String[] args) {
//        Room room1 = new Room(15.0);
//        Room room2 = new Room(20.0);
//
//        Apartment apartment = new Apartment();
//        apartment.addRoom(room1);
//        apartment.addRoom(room2);
//
//        Room room3 = new Room(17.0);
//        Room room4 = new Room(12.0);
//
//        Apartment apartment1 = new Apartment();
//        apartment1.addRoom(room3);
//        apartment1.addRoom(room4);
//
        House house = new House();
//        house.addApartment(apartment);
//        house.addApartment(apartment1);
//
//        double totalLivingArea = house.getTotalLivingArea();
//        System.out.println("Total living area: " + totalLivingArea);
        /*Среди всех квартир найдите квартиру, площадь которой больше 100 кв. м.
 Если такая квартира найдена, то выведите её площадь.
 В противном случае выведите сообщение, что такой квартиры нет.*/

//        house.findApartmentAreaMoreThan100();

/*Старый дом расселяют. В новом доме жильцы должны получить квартиры большей площади.
Создайте новый список квартир дома, увеличив площадь каждой комнаты на 30%.*/
        house.increaseAllRoomsArea();

        double newTotalLivingArea = house.getTotalLivingArea();
        System.out.println("New total living area: " + newTotalLivingArea);

/* Дан список, каждый элемент которого – это мапа площадей комнат (комната - площадь).
Создайте новые квартиры с комнатами заданных площадей.*/
        List<Map<Room, ? extends Number>> roomsList = List.of(
                Map.of(new Room(1.0), 20.0),
                Map.of(new Room(2.0), 15),
                Map.of(new Room(3.0), 13),
                Map.of(new Room(4.0),15)
        );
        List<Apartment> apartments = roomsList.stream()
                .map(roomMap -> {
                    List<Room> rooms = roomMap.entrySet().stream()
                            .map(entry -> new Room(((Number) entry.getValue()).doubleValue()))
                            .collect(Collectors.toList());
                    return new Apartment(rooms);
                })
                .toList();

        apartments.forEach(apartment -> System.out.println("Площадь квартиры: " + apartment.getApartmentArea() + " кв. м."));
    }

}
