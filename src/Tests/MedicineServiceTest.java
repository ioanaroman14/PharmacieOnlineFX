package Tests;

import Domain.IValidator;
import Domain.Medicine;
import Domain.MedicineValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.MedicineService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicineServiceTest {
    private IValidator<Medicine>validatorMedicine = new MedicineValidator();
    private IRepository<Medicine>medicineIRepository = new InMemoryRepository<>(validatorMedicine);
    private MedicineService medicineService = new MedicineService(medicineIRepository);

    @Test
    void addOrUpdateMedicineTest() {
       medicineService.addOrUpdate("1","nurofen","terapia", 10,true);
       assertEquals(1,medicineService.getAll().size());
    }

    @Test
    void remove() {
        medicineService.addOrUpdate("1","nurofen","terapia", 10,true);
        medicineService.remove("1");
        assertEquals(0, medicineService.getAll().size());
    }

    @Test
    void getAll() {
        medicineService.addOrUpdate("1","nurofen","terapia", 10,true);
        medicineService.getAll();
        assertEquals(1, medicineService.getAll().size());
    }
}