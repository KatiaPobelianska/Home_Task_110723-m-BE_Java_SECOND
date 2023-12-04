package home_task_23_11_30.tasks_1_2_3_4;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Apartment> apartmentList;
    public House(){
        apartmentList = new ArrayList<>();
    }
    public void addApartment(Apartment apartment){
        apartmentList.add(apartment);
    }
    public double getTotalLivingArea(){
        double totalArea = 0;
        for (Apartment apartment: apartmentList){
            totalArea += apartment.getApartmentArea();
        }
        return totalArea;
    }
    public void findApartmentAreaMoreThan100(){
        boolean found = false;
        for (Apartment apartment: apartmentList){
            double apartmentArea = apartment.getApartmentArea();
            if (apartmentArea > 100){
                found = true;
                System.out.println("Найдена квартира с площадью больше 100 кв. м: " + apartmentArea);
            }
        }
        if (!found){
            System.out.println("Такой кв нет");
        }
    }
    public void increaseAllRoomsArea(){
        for (Apartment apartment: apartmentList){
            apartment.increaseRoomsAreas();
        }
    }
}
