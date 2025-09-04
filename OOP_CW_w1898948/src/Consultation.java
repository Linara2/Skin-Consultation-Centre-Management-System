public class Consultation {
    private int date_time;
    private double cost;
    private String notes;

    public Consultation(int date_time, double cost, String notes){
        this.date_time = date_time;
        this.cost = cost;
        this.notes = notes;
    }

    public int getDate_time(){
        return date_time;
    }

    public void setDate_time(int date_time){
        this.date_time = date_time;
    }

    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }


}
