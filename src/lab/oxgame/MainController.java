package lab.oxgame;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lab.oxgame.dao.RozgrywkaDAO;
import lab.oxgame.dao.RozgrywkaDAOImpl;
import lab.oxgame.engine.OXGame;
import lab.oxgame.engine.OXGameImpl;
import lab.oxgame.model.OXEnum;
import lab.oxgame.model.Rozgrywka;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private RozgrywkaDAO rozgrywkaDAO;
	private ExecutorService executor;
	private OXGame oxGame;
	
	@FXML
	private TableView<Rozgrywka> rozgrywkaTable;
	@FXML
	private TableColumn<Rozgrywka, Integer> rozgrywkaIdColumn;
	@FXML
	private TableColumn<Rozgrywka, String> graczXColumn;
	@FXML
	private TableColumn<Rozgrywka, String> graczOColumn;
	@FXML
	private TableColumn<Rozgrywka, OXEnum> zwyciezcaColumn;
	@FXML
	private TableColumn<Rozgrywka, LocalDateTime> dataczasRozgrywkiColumn;
	
	private ObservableList<Rozgrywka> history;
	
	public MainController() {
		rozgrywkaDAO = new RozgrywkaDAOImpl();
		oxGame = new OXGameImpl();
	}
	
	@FXML
	private void initialize() {
		oxGame.inicjalizuj();
		//1. Powi¹zanie kolumn z polami klasy rozgrywka
		rozgrywkaIdColumn.setCellValueFactory(new PropertyValueFactory<Rozgrywka, Integer>("rozgrywkaId"));
		graczOColumn.setCellValueFactory(new PropertyValueFactory<Rozgrywka, String>("graczO"));
		graczXColumn.setCellValueFactory(new PropertyValueFactory<Rozgrywka, String>("graczX"));
		zwyciezcaColumn.setCellValueFactory(new PropertyValueFactory<Rozgrywka, OXEnum>("zwyciezca"));
		dataczasRozgrywkiColumn.setCellValueFactory(new PropertyValueFactory<Rozgrywka, LocalDateTime>("dataczasRozgrywki"));
		//2. Utworzenie listy obserwowalnej i jej powi¹zanie tabel¹
		history = FXCollections.observableArrayList();
		rozgrywkaTable.setItems(history);
		//3. Pobranie z bazy historii i zaladowanie wynikow
		executor = Executors.newSingleThreadExecutor();
		executor.execute(() ->{
			List<Rozgrywka> rozgrywki = new ArrayList<>();
			try {
				rozgrywki.addAll(rozgrywkaDAO.findAll());
			}catch(Exception e) {
				String errMsg = "B³¹d podczas inicjalizacji historii rozgrywek!";
				logger.error(errMsg, e);
				String errDetails = e.getCause() != null ?//wbudowany if
						e.getMessage() + "\n" + e.getCause().getMessage()//if je¿eli tak
					:	e.getMessage();//if je¿eli nie
				Platform.runLater(() -> showError(errMsg, errDetails));
			}
			Platform.runLater(() -> history.addAll(rozgrywki));
		});
		
	}
	
	private void showError(String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("B³¹d");
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	@FXML
	private void onActionBtnReset(ActionEvent event) {
		//testDb();
	}
	@FXML
	public void onActionBtn0(ActionEvent event) {
		ruch((Button)event.getSource(), 0);
	}
	@FXML
	public void onActionBtn1(ActionEvent event) {
		ruch((Button)event.getSource(), 1);
	}
	@FXML
	public void onActionBtn2(ActionEvent event) {
		ruch((Button)event.getSource(), 2);
	}
	@FXML
	public void onActionBtn3(ActionEvent event) {
		ruch((Button)event.getSource(), 3);
	}
	@FXML
	public void onActionBtn4(ActionEvent event) {
		ruch((Button)event.getSource(), 4);
	}
	@FXML
	public void onActionBtn5(ActionEvent event) {
		ruch((Button)event.getSource(), 5);
	}
	@FXML
	public void onActionBtn6(ActionEvent event) {
		ruch((Button)event.getSource(), 6);
	}
	@FXML
	public void onActionBtn7(ActionEvent event) {
		ruch((Button)event.getSource(), 7);
	}
	@FXML
	public void onActionBtn8(ActionEvent event) {
		ruch((Button)event.getSource(), 8);
	}
	private void ruch(Button btn, int indeks) {
		OXEnum kolej = oxGame.getKolej();
		if(!OXEnum.BRAK.equals(oxGame.getKolej())) {
			btn.setText(kolej.toString());
			oxGame.setPole(indeks);
			kolej = oxGame.getKolej();
			//TODO
			//Jeœli koniec rozgrywki
			//zapis do bazy i aktualizacja listy
			//lub tylko aktualizacja komunikat ruch gracza x
		}
	}

	private void testDb() {
		Rozgrywka rozgrywka = new Rozgrywka("Jan","Julia",OXEnum.O,LocalDateTime.now());
		rozgrywkaDAO.save(rozgrywka);
		logger.info("Id utworzonej rozgrywki {}", rozgrywka.getRozgrywkaId());
		
		List<Rozgrywka> rozgrywki = rozgrywkaDAO.findAll();
		for(Rozgrywka r : rozgrywki) {
			logger.info("Rozgrywka - Id: {}, O: {}, X: {}", r.getRozgrywkaId(), r.getGraczO(), r.getGraczX());
		}
	}
}
