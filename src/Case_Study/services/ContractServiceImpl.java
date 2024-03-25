package Case_Study.services;

import Case_Study.models.Booking;
import Case_Study.models.Contract;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class ContractServiceImpl implements ContractService {

    private final String FILE_PATH = "C:\\Users\\longb\\IdeaProjects\\Module2_Java\\src\\Case_Study\\data\\contract.csv";

    List<Contract> contracts = readFile();

    @Override
    public void createContracts(Queue<Booking> bookingQueue) {
        Scanner scanner = new Scanner(System.in);
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();

            System.out.println(booking);
            System.out.println("-------->");
            System.out.print("Number : ");
            int number = scanner.nextInt();
            System.out.print("Deposit : ");
            double deposit = scanner.nextDouble();
            System.out.print("Payment : ");
            double payment = scanner.nextDouble();

            Contract contract = new Contract(booking.getIdBooking(),booking.getIdCustomer(),number,deposit,payment);

            writeFile(contract,true);
            contracts.add(contract);
        }
    }

    @Override
    public List<Contract> findAllContracts() {
        return contracts;
    }

    @Override
    public void update(int id) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getIdBooking() == id) {
                System.out.print("Number : ");
                int number = scanner.nextInt();
                System.out.print("Deposit : ");
                double deposit = scanner.nextDouble();
                System.out.print("Payment : ");
                double payment = scanner.nextDouble();

                contracts.get(i).setNumber(number);
                contracts.get(i).setDeposit(deposit);
                contracts.get(i).setPayment(payment);

                for (int j = 0; j < contracts.size(); j++) {
                    writeFile(contracts.get(j), j != 0);
                }
            }
        }
    }

    public List<Contract> readFile() {
        List<Contract> contractsReader = new LinkedList<>();

        try{
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] data;

            while((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                Contract contract = new Contract(Integer.parseInt(data[0]),Integer.parseInt(data[1]) ,Integer.parseInt(data[2]) , Double.parseDouble(data[3]), Double.parseDouble(data[4]) );
                contractsReader.add(contract);
            }

            bufferedReader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return contractsReader;
    }

    public void writeFile(Contract contractWrite, boolean newData){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH,newData);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    contractWrite.getIdBooking() + "," +
                            contractWrite.getIdCustomer() + "," +
                            contractWrite.getNumber()+ "," +
                            contractWrite.getDeposit()+"," +
                            contractWrite.getPayment());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }


}
