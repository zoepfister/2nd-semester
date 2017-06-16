/**
 * Created by clemenspfister on 16/06/2017.
 */
public class FactoryProducer {
    public static DeviceFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("PHONE")){
            return new PhoneFactory();
        } else if (choice.equalsIgnoreCase("LAPTOP")){
            return new LaptopFactory();
        }
        return null;
    }
}
