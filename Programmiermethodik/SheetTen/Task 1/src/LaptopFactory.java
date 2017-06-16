/**
 * Created by clemenspfister on 16/06/2017.
 */
public class LaptopFactory extends DeviceFactory {

    @Override
    Phone getPhone(String phone) {
        return null;
    }

    @Override
    Laptop getLaptop(String laptop) {
        if (laptop.equals(null)){
            return null;
        }
        if (laptop.equalsIgnoreCase("LENOVO")){
            return new Lenovo();
        } else if (laptop.equalsIgnoreCase("HP")){
            return new HP();
        }
        return null;
    }
}
