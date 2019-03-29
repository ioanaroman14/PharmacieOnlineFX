package Domain;

public class CExceptionCardClientValidator extends RuntimeException {
    String str;
    public CExceptionCardClientValidator (String str){
        this.str = str;
    }

    public CExceptionCardClientValidator(String message, Throwable cause) {
        super(message, cause);
    }




    public String toString(){
        return ("message = " +str);
    }
    // public CustomException1 (String message){
    //   super(message);
    //
    // }

    public CExceptionCardClientValidator() {
    }
}

