package Domain;

import UI.CustomException;

public class TransactionValidator implements IValidator<Transaction> {
    public void validate (Transaction transaction) throws CExceptionTransactionValidator {
        if (transaction.getNumberOfItems() <= 0) {
            throw new CExceptionTransactionValidator("The number of items must be at least 1!");
        }
    }
}
