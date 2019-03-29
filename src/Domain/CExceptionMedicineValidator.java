package Domain;

public class CExceptionMedicineValidator extends RuntimeException {
    String str;
    public CExceptionMedicineValidator (String str){
        this.str = str;
    }






    public String toString(){
        return ("message = " +str);
    }

}


