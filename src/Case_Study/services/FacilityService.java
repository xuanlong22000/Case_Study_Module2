package Case_Study.services;

import java.util.LinkedHashMap;

public interface FacilityService extends Service{
    LinkedHashMap<Object,Integer> findAll();
    void add();
    void findAllMaintenance();
}
