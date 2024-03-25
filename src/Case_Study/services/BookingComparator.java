package Case_Study.services;

import Case_Study.models.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking b1, Booking b2) {
        int startDateComparison = b1.getStartDate().compareTo(b2.getStartDate());
        if (startDateComparison != 0) {
            return startDateComparison;
        }
        return b1.getEndDate().compareTo(b2.getEndDate());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
