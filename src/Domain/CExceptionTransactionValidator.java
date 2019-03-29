package Domain;

public class CExceptionTransactionValidator extends RuntimeException {
    String str;
    public CExceptionTransactionValidator(String str) {
        this.str = str;
    }
    public String toString() {
        return ("message = " + str);
    }
}


