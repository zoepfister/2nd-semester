/**
 * Created by clemenspfister on 16/06/2017.
 */
public abstract class DeviceFactory {
    abstract Phone getPhone(String phone);
    abstract Laptop getLaptop(String laptop);
}
