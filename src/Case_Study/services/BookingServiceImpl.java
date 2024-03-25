package Case_Study.services;

import Case_Study.models.Booking;
import Case_Study.models.Contract;
import Case_Study.models.Customer;
import Case_Study.models.Person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    private final String FILE_PATH = "C:\\Users\\longb\\IdeaProjects\\Module2_Java\\src\\Case_Study\\data\\booking.csv";

    TreeSet<Booking> bookings = readFile();
    Queue<Booking> bookingQueue = new LinkedList<>();

    @Override
    public TreeSet<Booking> findAll() {
        return bookings;
    }

    @Override
    public Queue<Booking> findAllBookingQueue() {
        return bookingQueue;
    }

    @Override
    public void add(Booking booking, List<Customer> customers, LinkedHashMap<Object,Integer> facilities) {
        if (!bookings.contains(booking)) {
            writeFile(booking,true);
            bookings.add(booking);
            bookingQueue.offer(booking);
        }
    }
    public TreeSet<Booking> readFile() {
        TreeSet<Booking> bookingReader = new TreeSet<>(new BookingComparator());
        SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");

        try{
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] data;

            while((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                Booking booking = new Booking(Integer.parseInt(data[0]),Integer.parseInt(data[1]) ,dateFormat.parse(data[2]), dateFormat.parse(data[3]), data[4], data[5]);
                bookingReader.add(booking);
            }

            bufferedReader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return bookingReader;
    }

    public void writeFile(Booking bookingWrite, boolean newData){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH,newData);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    bookingWrite.getIdBooking() + "," +
                            bookingWrite.getIdCustomer() + "," +
                            bookingWrite.getStartDate()+ "," +
                            bookingWrite.getEndDate()+"," +
                            bookingWrite.getNameService()+ "," +
                            bookingWrite.getTypeOfService());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
