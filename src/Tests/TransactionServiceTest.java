package Tests;

import Domain.IValidator;
import Domain.Medicine;
import Domain.Transaction;
import Domain.TransactionValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.TransactionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {
        private IValidator<Transaction> validatorTransaction = new TransactionValidator();
        private IRepository<Transaction> transactionInMemoryRepository = new InMemoryRepository<>(validatorTransaction);
        private TransactionService transactionService = new TransactionService(transactionInMemoryRepository);

    @Test
        public void addOrUpdate() {
            transactionService.addOrUpdate("1", "3", "4", 10, "10.10.1990", "12");
            assertEquals(1, transactionService.getAll().size());
        }

        @Test
        void remove() {
            transactionService.addOrUpdate("1","3","4",10,"10.10.1990","12");
            transactionService.remove("1");
            assertEquals(0,transactionService.getAll().size());
        }


    }