package Case_Study.services;

import Case_Study.models.*;
import Case_Study.utils.FacilityValidator;
import Case_Study.utils.InvalidDataException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService{
    private final String FILE_PATH_VILLA = "C:\\Users\\longb\\IdeaProjects\\Module2_Java\\src\\Case_Study\\data\\villa.csv";
    private final String FILE_PATH_ROOM = "C:\\Users\\longb\\IdeaProjects\\Module2_Java\\src\\Case_Study\\data\\room.csv";
    private final String FILE_PATH_HOUSE = "C:\\Users\\longb\\IdeaProjects\\Module2_Java\\src\\Case_Study\\data\\house.csv";

    LinkedHashMap<Object,Integer> facilities = readFile();


    @Override
    public LinkedHashMap<Object, Integer> findAll() {
        return facilities;
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        FacilityValidator facilityValidator = new FacilityValidator();
        while (true){
            System.out.println("1.Add New Villa");
            System.out.println("2.Add New House");
            System.out.println("3.Add New Room");
            System.out.println("4.Back to menu");
            System.out.println("-----------------------------");

            int select = scanner.nextInt();

            if (select == 4) {
                break;
            }

            switch (select){
                case 1:
                    System.out.print("Name : ");
                    String name = scanner.next();
                    System.out.print("Area : ");
                    double area = scanner.nextDouble();
                    System.out.print("Price : ");
                    double price = scanner.nextDouble();
                    System.out.print("MaxCustomers : ");
                    int maxCustomers = scanner.nextInt();
                    System.out.print("Type Of Renting : ");
                    String typeRenting = scanner.next();
                    System.out.print("Room Standard : ");
                    String roomStandard = scanner.next();
                    System.out.print("PoolArea : ");
                    double poolArea = scanner.nextDouble();
                    System.out.print("NumberOfFloor : ");
                    int numberOfFloor = scanner.nextInt();
                    Villa villa = new Villa(name,area,price,maxCustomers,typeRenting,roomStandard,poolArea,numberOfFloor);


//                    try {
//                        facilityValidator.validateFacility();
//                    }catch (Exception e){
//
//                    }
                    writeFileVilla(villa,true);
                    facilities.put(villa,0);
                    break;
                case 2:
                    System.out.print("Name : ");
                    String name2 = scanner.next();
                    System.out.print("Area : ");
                    double area2 = scanner.nextDouble();
                    System.out.print("Price : ");
                    double price2 = scanner.nextDouble();
                    System.out.print("MaxCustomers : ");
                    int maxCustomers2 = scanner.nextInt();
                    System.out.print("Type Of Renting : ");
                    String typeRenting2 = scanner.next();
                    System.out.print("FreeService : ");
                    String freeService = scanner.next();

                    Room room = new Room(name2,area2,price2,maxCustomers2,typeRenting2,freeService);

                    writeFileRoom(room,true);
                    facilities.put(room,0);
                    break;
                case 3:
                    System.out.print("Name : ");
                    String name3 = scanner.next();
                    System.out.print("Area : ");
                    double area3 = scanner.nextDouble();
                    System.out.print("Price : ");
                    double price3 = scanner.nextDouble();
                    System.out.print("MaxCustomers : ");
                    int maxCustomers3 = scanner.nextInt();
                    System.out.print("Type Of Renting : ");
                    String typeRenting3 = scanner.next();
                    System.out.print("Room Standard : ");
                    String roomStandard3 = scanner.next();
                    System.out.print("NumberOfFloor : ");
                    int numberOfFloor3 = scanner.nextInt();
                    House house = new House(name3,area3,price3,maxCustomers3,typeRenting3,roomStandard3,numberOfFloor3);

                    writeFileHouse(house,true);
                    facilities.put(house,0);
                    break;
                default:
                    System.out.println("Number not available");
                    break;
            }
        }
    }

    @Override
    public void findAllMaintenance() {
        Set<Object> keySet = facilities.keySet();
        for (Object key : keySet) {
            if (facilities.get(key) >= 5) {
                System.out.println(key + " : " + facilities.get(key));
            }
        }
    }

    public void writeFileVilla(Villa villaFacility, boolean newData){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH_VILLA,newData);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    villaFacility.getName() + "," +
                            villaFacility.getArea() + "," +
                            villaFacility.getPrice()+ "," +
                            villaFacility.getMaxCustomers()+"," +
                            villaFacility.getTypeRenting()+ "," +
                            villaFacility.getRoomStandard()+"," +
                            villaFacility.getPoolArea()+"," +
                            villaFacility.getNumberOfFloor());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void writeFileRoom(Room roomFacility, boolean newData){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH_ROOM,newData);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    roomFacility.getName() + "," +
                            roomFacility.getArea() + "," +
                            roomFacility.getPrice()+ "," +
                            roomFacility.getMaxCustomers()+"," +
                            roomFacility.getTypeRenting()+ "," +
                            roomFacility.getFreeService());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void writeFileHouse(House houseFacility, boolean newData){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH_HOUSE,newData);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    houseFacility.getName() + "," +
                            houseFacility.getArea() + "," +
                            houseFacility.getPrice()+ "," +
                            houseFacility.getMaxCustomers()+"," +
                            houseFacility.getTypeRenting()+ "," +
                            houseFacility.getRoomStandard()+ "," +
                            houseFacility.getNumberOfFloor());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public LinkedHashMap<Object,Integer> readFile() {
        LinkedHashMap<Object,Integer> facilitiesReader = new LinkedHashMap<>();

        try{
            FileReader fileReaderVilla = new FileReader(FILE_PATH_VILLA);
            FileReader fileReaderRoom = new FileReader(FILE_PATH_ROOM);
            FileReader fileReaderHouse = new FileReader(FILE_PATH_HOUSE);

            BufferedReader bufferedReaderVilla = new BufferedReader(fileReaderVilla);
            BufferedReader bufferedReaderRoom = new BufferedReader(fileReaderRoom);
            BufferedReader bufferedReaderHouse = new BufferedReader(fileReaderHouse);


            String line;
            String[] data;

            while((line = bufferedReaderVilla.readLine()) != null){
                data = line.split(",");
                Villa villa = new Villa(data[0], Double.parseDouble(data[1]) ,Double.parseDouble(data[2]) ,Integer.parseInt(data[3]) , data[4],data[5],Double.parseDouble(data[6]) , Integer.parseInt(data[7]));
                facilitiesReader.put(villa,0);
            }

            bufferedReaderVilla.close();

            while((line = bufferedReaderRoom.readLine()) != null){
                data = line.split(",");
                Room room = new Room(data[0], Double.parseDouble(data[1]) ,Double.parseDouble(data[2]) ,Integer.parseInt(data[3]) , data[4],data[5]);
                facilitiesReader.put(room, 0);
            }

            bufferedReaderRoom.close();

            while((line = bufferedReaderHouse.readLine()) != null){
                data = line.split(",");
                House house = new House(data[0], Double.parseDouble(data[1]) ,Double.parseDouble(data[2]) ,Integer.parseInt(data[3]) , data[4],data[5],Integer.parseInt(data[6]) );

                facilitiesReader.put(house, 0);
            }

            bufferedReaderHouse.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return facilitiesReader;
    }

}
