
interface IEngine{
    public boolean start();
}

interface ITransmission{
    public boolean changeGear(int gear);
    public boolean check();
}

interface IStartupMotor{
    public boolean start();
}

interface IFuelPump{
    public boolean start();
}

class Car{
    String name;
    IEngine engine;
    ITransmission transmission;
    Car(String name,IEngine engine,ITransmission transmission){
        this.name=name;
        this.engine=engine;
        this.transmission=transmission;
    }
    void start(){
        if(engine.start() && transmission.check()){
            System.out.println("starting car");
        }
    }
}

class Engine implements IEngine{
    String type;
    IFuelPump fuelpump;
    IStartupMotor startupmotor;
    Engine(IFuelPump fuelpump,IStartupMotor startupmotor,String type){
        this.type=type;
        this.fuelpump=fuelpump;
        this.startupmotor=startupmotor;
    }
    public boolean start(){
        if(fuelpump.start() && startupmotor.start()){
            System.out.println("starting engine");
            return true;
        }
        return false;
    }
}

class Transmission implements ITransmission{
    int gear=0;
    public boolean changeGear(int gear){
        this.gear=gear;
        System.out.println("Gear changed to: "+gear);
        return true;
    }
    public boolean check(){
        System.out.println("transmission working");
        return true;
    }
}

class StartupMotor implements IStartupMotor{
    public boolean start(){
        System.out.println("starting motor");
        return true;
    }
}

class FuelPump implements IFuelPump{
    public boolean start(){
        System.out.println("starting fuel pump");
        return true;
    }
}

class HelloWorld {
    public static void main(String[] args) {
        IFuelPump fuelpump=new FuelPump();
        IStartupMotor startupmotor=new StartupMotor();
        IEngine engine=new Engine(fuelpump,startupmotor,"Diesel");
        ITransmission transmission=new Transmission();
        Car car=new Car("taigun",engine,transmission);
        car.start();
        transmission.changeGear(2);
    }
}
