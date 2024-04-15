package booksearch.controller;

import java.net.URL;
import java.util.ResourceBundle;

import booksearch.service.BookService;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookSearchController implements Initializable {
	
	@FXML private TextField textField;
	@FXML private Button searchBtn;
	@FXML private Button deleteBtn;
	@FXML private TableView tableView;
	@FXML private TableColumn<BookVO, String> isbn; 
	@FXML private TableColumn<BookVO, String> title; 
	@FXML private TableColumn<BookVO, Integer> price; 
	@FXML private TableColumn<BookVO, String> author; 
	
	private String deleteIsbn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// VO의 어떤 field가 tableView의 어떤 column에 매핑 되는지 설정
		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		
		// tableView에서 각각의 row에 대한 처리하고 싶을 때
		tableView.setRowFactory(e -> {
			// tableView에 row가 만들어질 때마다 실행
			TableRow<BookVO> row = new TableRow<BookVO>();
			// row 클릭했을 때 event 처리, 마우스 클릭에 대한 리스너
			row.setOnMouseClicked(event -> {
				// 더블클릭이 아니고 비어있지 않을 때
				if(event.getClickCount()==1 && !row.isEmpty()) {
					BookVO book = row.getItem();
					deleteIsbn = book.getBisbn(); // primary key 값
				}
			});
			
			return row;
		});
		
		// 이벤트 처리
		searchBtn.setOnAction(e -> {
			// controller에서는 로직 처리를 하지 않음
			// 로직처리하는 객체(Service)를 이용해서 일을 시킴(method를 호출)
			// 사실은 버튼 누를 때마다 객체를 만들 필요 없고, 메소드만 바꿔쓰면 되긴 함
			BookService service = new BookService();
			
			// 책들에 대한 정보를 list로 받아와서 화면에 표시
			// 이때 ObservableList라는 JavaFX의 특수한 List 형태로 VO의 집합 받기
			ObservableList<BookVO> list =
					service.searchBookByKeyword(textField.getText());
			// 처리된 결과를 받아서 화면을 제어하기
			tableView.setItems(list);
			
		});
		
		deleteBtn.setOnAction(e -> {
			BookService service = new BookService(); //한번 만들어 놓고 계속 쓰면 안되나..?
			//지우고 다시 검색해서 가지고 오기
			ObservableList<BookVO> list =
					service.deleteSelectedBook(deleteIsbn, textField.getText()); 
			tableView.setItems(list);
		});
		
	}

}
