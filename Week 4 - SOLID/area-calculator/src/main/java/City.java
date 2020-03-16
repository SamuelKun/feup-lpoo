import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider{
    List<House> houseList = new ArrayList<House>();

    public City(List<House> houses_list) {
        for (House house : houses_list)
            houseList.add(house);
    }

    public void addHouse(House h) {
        houseList.add(h);
    }

    public double sum() {
        double s = 0;
        for (House house : houseList)
            s += house.getArea();
        return s;
    }
}
