package es.unileon.prg.date;

public class Date { 

    private int day;
    private int month;
    private int year;

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public Date(int day, int month, int year) throws DateException  {
        if(year <= 0) {
			throw new DateException("Anyo debe ser positivo");
		}else{
			this.year = year;
		}
		if(month < 1 || month > 12) {
			throw new DateException("El mes debe estar entre 1 y 12");
		}else{
			this.month = month;
		}
		if(isDayOfMonthRight(day,month) == false) {
			throw new DateException("Dia no valido para este mes");
		}else{
            this.day = day;
        }
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

    public void setYear(int newYear) throws DateException {
        if(year<=0) {
            throw new DateException("El anyo es negativo");
        }else{
            this.year=year;
        }
    }

    public void setMonth(int newMonth) throws DateException {

        if(newMonth<1 || newMonth>12){
            throw new DateException("El mes dado debe estar entre 1 y 12");
        }else{
            this.month = newMonth;
        }
    } 

    public void setDay(int newDay) throws DateException {

        if(newDay < 1) {
            throw new DateException("Los dias negativos no existen");
        } else if(newDay>31) {
            throw new DateException("No hay dias mayores que 31");
        }else if(isDayOfMonthRight(this.day,this.month) == false) {
			throw new DateException("Dia no valido para este mes");
        }else{
        this.day = day;
        }
    }

    public boolean isSameDay(Date other) {
        if(this.day == other.getDay()) {
            return true;
        }else{

            return false;
        }
    }

    public boolean isSameMonth(Date other) {
        if(this.month == other.getMonth()) {
            return true;

        }else{

            return false;
        }
    }

    public boolean isSameYear(Date other) {
        if(this.year == other.getYear()) {
            return true;

        }else{
        
            return false;
        }

    }

    public boolean isSame(Date other) {
        if(isSameYear(other) && isSameMonth(other) && isSameDay(other)) {
            return true;

        }else{
            
            return false;
        }
    }

	public boolean isSameDay2(Date other){
		return this.getDay() == other.getDay();
	}

	public boolean isSameMonth2(Date other){
		return this.getMonth() == other.getMonth();
	}

	public boolean isSameYear2(Date other){
		return this.getYear() == other.getYear();
	}

	public boolean isSame2(Date other){
		return isSameDay2(other)&& isSameMonth2(other) && isSameYear2(other);
	}

    public String getMonthName() {
        
        StringBuilder input =  new StringBuilder();
		switch (this.month) {
			
			case 1: 
				input.append("Enero") ;
				break;
			case 2: 
				input.append("Febrero") ;
				break;
			case 3: 
				input.append("Marzo");
				break;
			case 4: 
				input.append("Abril");
				break;
			case 5: 
				input.append("Mayo");
				break;
			case 6: 
				input.append("Junio");
				break;
			case 7: 
				input.append("Julio");
				break;
			case 8: 
				input.append("Agosto");
				break;
			case 9: 
				input.append("Septiembre");
				break;
			case 10: 
				input.append("Octubre");
				break;
			case 11: 
				input.append("Noviembre");
				break;
			case 12: 
				input.append("Diciembre");
				break;		
		}
		return input.toString();		
	}
    
    private boolean isDayOfMonthRight(int day, int month) {

        boolean esCorrecto=true;
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                    if(day<1 || day>31) {
						esCorrecto=false;
					}
					break;
            case 4:
            case 6:
            case 9:
            case 11:
                    if(day<1 || day>30) {
						esCorrecto=false;
					}
					break;
            case 2:
                    if(day<1 || day>28) {
						esCorrecto=false;
					}
					break;
        }return esCorrecto;
        
    }

    public String getSeasonOfTheMonth() {
        //Las estaciones estan determinadas en funcion del primer dia de cada mes
        StringBuilder input = new StringBuilder();

        switch(this.month) {
            case 1:
            case 2:
            case 3: input.append("Invierno");
                    break;
            case 4:
            case 5:
            case 6: input.append("Primavera");
                    break;
            case 7:
            case 8:
            case 9: input.append("Verano");
                    break;
            case 10:
            case 11:
            case 12:input.append("Otonyo");
                    break;
            } return input.toString();

    }

    public String getMonthsLeft() {
	
       StringBuilder input = new StringBuilder();
	
		if(this.month == 12) {
			input.append("Quedan 0 meses");
		}

		for(int i = this.month+1 ; i <= 12 ; i++) {
			this.month+=1;
			 input.append(getMonthName());
			 input.append(" ");
			 
		}
		return input.toString();
    }

    public String stringVersionOfDate(){

		return this.day + " de " + this.getMonthName() + " del " + this.year;
    }

    public String getDaysLeftOfMonth(){
		StringBuilder input = new StringBuilder();

		switch (this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				for(int i=this.day+1; i<=31 ; ++i ) {
					
					input.append(i + "/" + this.month + "/" + this.year);
					input.append(" ");
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				for (int i=this.day+1; i<=30 ; ++i ) {
					
					input.append(i + "/" + this.month + "/" + this.year);
					input.append(" ");
				}
				break;
            case 2:
				for(int i=this.day+1; i<=28 ; ++i ) {
					
					input.append(i + "/" + this.month + "/" + this.year);
					input.append(" ");
				}
				break;
		}
		return input.toString();
	}

    public String getMonthsWithSameDays(){

		StringBuilder input = new StringBuilder();

		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				input.append("Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre tienen los mismos dias que la fecha dada");
				break;
			case 2:
				input.append("Febrero tiene los mismos dias que la fecha dada");
				break;
			case 4: 
			case 6:
			case 9:
			case 11:
				input.append("Abril, Junio, Septiembre y Noviembre tienen los mismos dias que la fecha dada");
				break;


		}
		return input.toString();
	}

    public int daysSinceFirstDayOfYear(){
		
		int diasPasados=0;
		
		for(int i = 1;i<this.month ; i++) {
		 	switch(i) {
		 		case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
					diasPasados += 31;
					break;
				case 2:
					diasPasados += 28;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					diasPasados += 30;
					break;
		 	}
		} 
		diasPasados += this.day-1;

		return diasPasados;
	}

	public int numAttempsNeeded() {	
		
		int diaAleatorio=365;
		int attempts =0;
		
		while(this.daysSinceFirstDayOfYear() != diaAleatorio) {
			diaAleatorio = (int)(Math.random()*365);
			attempts++;
		}
		return attempts;
	}

	public int numAttempsNeeded2() {
		
		int diaAleatorio=365;
		int attempts =0;

		if(this.daysSinceFirstDayOfYear() == diaAleatorio) {
			return attempts=1;
		}else{
		do {
			attempts =1;
			diaAleatorio =(int)(Math.random()*365);
			attempts++;
		}while(this.daysSinceFirstDayOfYear() != diaAleatorio);
		return attempts;
		}
	}

	public String dayOfTheWeek(int primerDiaAnyo){

		StringBuilder input = new StringBuilder();
		int diaSemana = (this.daysSinceFirstDayOfYear()%7)+primerDiaAnyo;
		
			switch (diaSemana) {

				case 1:
					input.append("Lunes");
					break;
				case 2:
					input.append("Martes");
					break;
				case 3:	
					input.append("Miercoles");
					break;
				case 4:
					input.append("Jueves");
					break;
				case 5:
					input.append("Viernes");
					break;
				case 6:
					input.append("Sabado");
					break;
				case 7:
					input.append("Domingo");
					break;
			}
		return input.toString();
	}

	
	
	
}

