import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
    //... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
    public Physician(Integer id) {
        super(id);
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    @Override
    public boolean assignPin(int pin) {
        // TODO Auto-generated method stub;
        int length = String.valueOf(pin).length();
        if (length == 4) {
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        // TODO Auto-generated method stub
        System.out.println(this.getId());
        if( confirmedAuthID == this.getId()) {
            return true;
        }
        return false;
    }
	
    // TO DO: Setters & Getters

}
