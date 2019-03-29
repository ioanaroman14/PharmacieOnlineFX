package Tests;

import Domain.CardClient;
import Domain.CardClientValidator;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.CardClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardClientServiceTest {
    private IValidator<CardClient> cardClientIValidator = new CardClientValidator();
    private IRepository<CardClient> cardClientRepository = new InMemoryRepository<>(cardClientIValidator);
    private CardClientService cardClientService = new CardClientService(cardClientRepository);

    @Test
    public void addOrUpdate() {
        cardClientService.addOrUpdate("1","ioana","roman","2801014125811","12.10.1990","11.12.2019");
         assertEquals(1, cardClientService.getAll().size());
    }

    @Test
    void fullTextSearch() {
        cardClientService.addOrUpdate("1","ioana","roman","2801014125811","12.10.1990","11.12.2019");
        assertEquals(1,cardClientService.fullTextSearch("rr").size());
        assertEquals(0, cardClientService.fullTextSearch("aght").size());
    }

    @Test
    void remove() {
        cardClientService.addOrUpdate("1","ioana","roman","2801014125811","12.10.1990","11.12.2019");
        cardClientService.remove("1");
        assertEquals(0,cardClientService.getAll().size());
    }


}