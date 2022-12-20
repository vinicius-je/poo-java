package entities;

import java.util.Date;

public class HourContract {
    //Atributos
    private java.util.Date date;
    private Double valuePerHour;
    private Integer hours;

    //Construtor
    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    //Getters
    public java.util.Date getDate() {
        return date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    //Setters
    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    //Métodos
    public Double totalValue(){
        return valuePerHour * hours;
    }
}
