package home_task_23_11_30.tasks_1_2_3_4;

import java.util.List;

public class Apartment {
    private List<Room> rooms;

    public Apartment(List<Room> rooms){
        this.rooms = rooms;
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public double getApartmentArea(){
     return rooms.stream()
             .mapToDouble(Room::getArea)
             .sum();
    }
    public void increaseRoomsAreas(){
        for (Room room: rooms){
            room.increaseArea();
        }
    }
}
