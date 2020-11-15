package es.unileon.prg.date;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date() {
        this.date = 1;
        this.month = 1;
        this.year = 2000;
    }

    public Date(int day, int month, int year) throws DateException  {
        //TO-DO Comprobar validez de la fecha
        this.day = this.setDay(day);
        this.month = this.month(month);
        this.year = this.year(year);
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int newDay) throws DateException {
        if(newDay < 1) {
            throw new DateException("Los dias negativos no existen");
        } else if(newDay>31) {
            throw new DateException("No hay dias mayores que 31");
        }

        this.day = newDay;
        }
    }

    public boolean isSameDay(Date other) {
        if(this.day == other.getDay()) {
            return true;
        }

            return false;

    }

    public boolean isSameMonth(Date other) {
        if(this.month == other.getMonth()) {
            return true;

        }

            return false;

    }

    public boolean isSameYear(Date other) {
        if(this.year == other.getYear()) {
            return true;

        }
        
            return false;

    }

    public boolean isSame(Date other) {
        if(isSameYear=true && isSameMonth=true && isSameDay=true) {
            return true;

        }
            
            return false;

    }
}

