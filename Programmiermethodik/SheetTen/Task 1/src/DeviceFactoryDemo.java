/**
 * Created by clemenspfister on 16/06/2017.
 */
public class DeviceFactoryDemo {
    public static void main(String[] args) {

        DeviceFactory laptopFactory = FactoryProducer.getFactory("LAPTOP");

        Laptop laptop1 = laptopFactory.getLaptop("HP");
        laptop1.printDeviceBrand();

        Laptop laptop2 = laptopFactory.getLaptop("LENOVO");
        laptop2.printDeviceBrand();

        DeviceFactory phoneFactory = FactoryProducer.getFactory("PHONE");

        Phone phone1 = phoneFactory.getPhone("APPLE");
        phone1.printDeviceBrand();

        Phone phone2 = phoneFactory.getPhone("GOOGLE");
        phone2.printDeviceBrand();


    }
}
