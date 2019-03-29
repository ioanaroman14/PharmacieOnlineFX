package Domain;

import UI.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CardClientValidator implements IValidator<CardClient> {
    public void validate (CardClient cardClient){
        if (cardClient.getCNP().length() != 13){
            try {
                throw new CExceptionCardClientValidator("CNP-ul nu este corect");
            } catch (CExceptionCardClientValidator e) {
                System.out.println(e);
            }
        }

    SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            format.parse(cardClient.getDateOfBirth());
        } catch (ParseException pe) {
            try {
                throw new CExceptionCardClientValidator("The date of birth is not a correct format!");
            } catch (CExceptionCardClientValidator e) {
                e.printStackTrace();
            }
        }
         try {
             format.parse(cardClient.getDateOfRegistration());
         } catch (ParseException pe) {
             try {
                 throw new CExceptionCardClientValidator("The date of registration is not a correct format!");
             } catch (CExceptionCardClientValidator e) {
                 e.printStackTrace();
             }

         }
        }
    }


