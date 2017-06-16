/**
 * Created by clemenspfister on 16/06/2017.
 */
public class PhoneFactory extends DeviceFactory{

    @Override
    Phone getPhone(String phone) {
        if (phone.equals(null)){
            return null;
        }
        if (phone.equalsIgnoreCase("APPLE")){
            return new Apple();
        } else if (phone.equalsIgnoreCase("GOOGLE")){
            return new Google();
        }
        return null;
    }

    @Override
    Laptop getLaptop(String laptop) {
        return null;
    }
}
