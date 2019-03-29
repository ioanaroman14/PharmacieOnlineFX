
import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.CardClientService;
import Service.MedicineService;
import Service.TransactionService;
import UI.Console;
import UI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import UI.Console;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource("UI/mainWindow.fxml"));
        Parent root = fxmlLoader.load();

        IValidator<Medicine> medicineValidator = new MedicineValidator();
        IValidator<CardClient> cardClientValidator = new CardClientValidator();
        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Medicine> medicineRepository = new InMemoryRepository<>(medicineValidator);
        IRepository<CardClient> cardClientRepository = new InMemoryRepository<>(cardClientValidator);
        IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);

        MedicineService medicineService = new MedicineService(medicineRepository);
        medicineService.addOrUpdate("1","Nurofen","Terapia",10, true);
        medicineService.addOrUpdate("2","Paracetamol","Dacia Plant",20,false);
        medicineService.addOrUpdate("3","Algocalmin","Terapia",30,true);

        CardClientService cardClientService = new CardClientService(cardClientRepository);
        cardClientService.addOrUpdate("2","Ioana", "Roman",
                "2801014125822","12.10.1990", "15.03.2019");
        cardClientService.addOrUpdate("3","Ana", "Gherman",
                "2901014125822","13.10.1990", "16.03.2019");
        cardClientService.addOrUpdate("4","Maria", "Pop",
                "2901015125822","13.10.1991", "16.01.2019");


        TransactionService transactionService = new TransactionService(transactionRepository,medicineRepository);
       // TransactionService.addOrUpdate("2", "3","4",5, "12.10.2019","12");


        MainController mainController = fxmlLoader.getController();
        mainController.setServices(medicineService,cardClientService,transactionService);

       primaryStage.setTitle("Online Pharmacie");
       primaryStage.setScene(new Scene(root,2000,700));
       primaryStage.show();


    }
   /* public static void main(String[] args) {
        IValidator<Medicine> medicineValidator = new MedicineValidator();
        IValidator<CardClient> cardClientValidator = new CardClientValidator();
        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Medicine> medicineRepository = new InMemoryRepository<>(medicineValidator);
        IRepository<CardClient> cardClientRepository = new InMemoryRepository<>(cardClientValidator);
        IRepository<Transaction> transactionRepository  = new InMemoryRepository<>(transactionValidator);

        MedicineService medicineService = new MedicineService(medicineRepository);
        CardClientService cardClientService = new CardClientService(cardClientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, medicineRepository);

        Console console = new Console(medicineService, cardClientService, transactionService);
        console.run();

        //ConsoleLimbajNatural consoleLimbajNatural = new ConsoleLimbajNatural(medicineService,cardClientService,transactionService);
        //consoleLimbajNatural.run2();

    }*/
   public static void main (String[] args){
       launch(args);
   }
}
