package Case_Study.services;

import Case_Study.models.Booking;
import Case_Study.models.Contract;

import java.util.List;
import java.util.Queue;

public interface ContractService extends Service{
    void createContracts(Queue<Booking> bookingQueue);
    List<Contract> findAllContracts();

    void update(int id);
}
