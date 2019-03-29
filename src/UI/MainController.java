package UI;

import Domain.CardClient;
import Domain.Medicine;
import Domain.Transaction;
import Service.CardClientService;
import Service.MedicineService;
import Service.TransactionService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;


public class MainController {
    public TableView tblMedicines;
    public TableColumn colIdMedine;
    public TableColumn colNameMedicine;
    public TableColumn colProducerMedicine;
    public TableColumn colPriceMedicine;
    public TextField txtMedicineID;
    public TextField txtMedicineName;
    public TextField txtMedicineProducer;
    public TextField txtMedicinePrice;
    public Button btnAddMedicine;
    public TableColumn colRecipe;
    public CheckBox chkRecipe;
    public TableView tblCardClients;
    public TableColumn colIdCardClient;
    public TableColumn colLastNameClient;
    public TableColumn colFirstNameClient;
    public TableColumn colCNPCardClient;
    public TableColumn colDateOFBirth;
    public TableColumn colDateOfRegistration;
    public TextField txtClientId;
    public TextField txtClientLastName;
    public TextField txtClientFirstName;
    public TextField txtClientCNP;
    public TextField txtClientDateOfBirth;
    public TextField txtClientDateOfRegistration;
    public TableView tblTransaction;
    public TableColumn colTransactionId;
    public TableColumn colTransIdMedicine;
    public TableColumn colIdCardClientTrans;
    public TableColumn colDateTransaction;
    public TableColumn colTimeTransaction;
    public TableColumn colNumberOfItems;
    public TableColumn colbasePrice;
    public TableColumn colDiscount;
    public TextField txtTransactionId;
    public TextField txtMedicineTransId;
    public TextField txtClientTransaction;
    public TextField txtData;
    public TextField txtTime;
    public TextField txtNumberOfItems;
    public TextField txtBasePrice;
    public TextField txtDiscount;
    public Button btnAddTransaction;
    public Button btnRemoveMedicine;
    public Button btnAddClient;
    public Button btnRemoveCardClient;
    public Button btnRemoveTransaction;
    public Button btnFindFullText;


    private MedicineService medicineService;
    private CardClientService cardClientService;
    private TransactionService transactionService;

    private ObservableList<Medicine> medicines = FXCollections.observableArrayList();
    private ObservableList<CardClient> clients = FXCollections.observableArrayList();
    private ObservableList<Transaction> transactions = FXCollections.observableArrayList();

    public void setServices(MedicineService medicineService, CardClientService cardClientService, TransactionService transactionService) {
        this.medicineService = medicineService;
        this.cardClientService = cardClientService;
        this.transactionService = transactionService;
    }

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            medicines.addAll(medicineService.getAll());
            tblMedicines.setItems(medicines);
            clients.addAll(cardClientService.getAll());
            tblCardClients.setItems(clients);
            transactions.addAll(transactionService.getAll());
            tblTransaction.setItems(transactions);
        });
    }

    public void btnAddMedicineClick(javafx.event.ActionEvent actionEvent) {
        try {
            java.lang.String id = txtMedicineID.getText();
            java.lang.String name = txtMedicineName.getText();
            java.lang.String producer = txtMedicineProducer.getText();
            double price = Double.parseDouble(txtMedicinePrice.getText());
            boolean recipe = chkRecipe.isSelected();

            medicineService.addOrUpdate(id, name, producer, price, recipe);

            medicines.clear();
            medicines.addAll(medicineService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnAddClientClick(javafx.event.ActionEvent actionEvent) {
        try {
            java.lang.String id = txtClientId.getText();
            java.lang.String lastName = txtClientLastName.getText();
            java.lang.String firstName = txtClientFirstName.getText();
            java.lang.String CNP = txtClientCNP.getText();
            java.lang.String dateOfBirth = txtClientDateOfBirth.getText();
            java.lang.String dateOfRegistration = txtClientDateOfRegistration.getText();

            cardClientService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);

            clients.clear();
            clients.addAll(cardClientService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnAddTransactionClick(javafx.event.ActionEvent actionEvent) {
        try {
            java.lang.String id = txtTransactionId.getText();
            java.lang.String idMedicine = txtMedicineTransId.getText();
            java.lang.String idCardClient = txtClientTransaction.getText();
            int numberOfItems = Integer.parseInt(txtNumberOfItems.getText());
            java.lang.String date = txtData.getText();
            String time = txtTime.getText();
            // Double basePrice = Double.parseDouble(txtBasePrice.getText());
            //Double discount = Double.parseDouble(txtDiscount.getText());

            transactionService.addOrUpdate(id, idMedicine, idCardClient, numberOfItems, date, time);

            transactions.clear();
            transactions.addAll(transactionService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveMedicineClick(ActionEvent actionEvent) {
        try {
            java.lang.String id = txtMedicineID.getText();
            medicineService.remove(id);
            medicines.clear();
            medicines.addAll(medicineService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }

    }

    public void btnRemoveCardClientClick(ActionEvent actionEvent) {
        try {
            java.lang.String id = txtClientId.getText();
            cardClientService.remove(id);
            clients.clear();
            clients.addAll(cardClientService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveTransactionClick(ActionEvent actionEvent) {
        try {
            String id = txtTransactionId.getText();
            transactionService.remove(id);
            transactions.clear();
            transactions.addAll(transactionService.getAll());

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }


    public void btnFindFullTextClick(ActionEvent actionEvent) {
    }
}




