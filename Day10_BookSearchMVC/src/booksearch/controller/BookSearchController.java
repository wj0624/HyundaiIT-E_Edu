package booksearch.controller;
// package 분리

import java.net.URL;
import java.util.ResourceBundle;

import booksearch.service.BookSearchService;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookSearchController implements Initializable {
	
	@FXML private TextField textField;
	@FXML private Button searchBtn;
	@FXML private Button deleteBtn;
	@FXML private TableView<BookVO> tableView;
	
	@FXML private TableColumn<BookVO, String> isbn;
	@FXML private TableColumn<BookVO, String> title;
	@FXML private TableColumn<BookVO, Integer> price;
	@FXML private TableColumn<BookVO, String> author;
	
	public void searchBookByKeyword() {
		// controller 는 view 와 service 를 연결만 하는 것
		// controller 에서 로직 처리를 직접 하지 않음
		// 로직 처리를 위한 서비스 객체가 필요함
		BookSearchService service = new BookSearchService();
		// 해당 객체를 이용해서 그 객체의 메서드로 일을 시킴
		// 한번만 만들어놓고 갖다쓰면 되는 건데 일단 지금은 이렇게 함
		String keyword = textField.getText();
		ObservableList<BookVO> data = service.searchBookByKeyword(keyword);
		// 메서드를 통해 return 받은 data 를 ObservableList 에 받음
		tableView.setItems(data);
	}
	
	public void deleteSelectedBook() {
		BookSearchService service = new BookSearchService();
		service.deleteSelectedBook(tableView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		
		searchBtn.setOnAction(e -> {
			searchBookByKeyword();
		});
		
		textField.setOnAction(e -> {
			searchBookByKeyword();
		});
		
		deleteBtn.setOnAction(e -> {
			deleteSelectedBook();
		});
	}
	
}

