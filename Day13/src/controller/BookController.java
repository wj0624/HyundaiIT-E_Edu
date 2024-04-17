package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import service.BookService;
import vo.BookVO;

public class BookController implements Initializable {
	
	// fxml에서 필드명과 똑같은 id 찾아서 매핑
	@FXML private TextField textField;
	@FXML private Button searchBtn;
//	@FXML private Button updateBtn;
	@FXML private Button deleteBtn;
	@FXML private TableView tableView;
	@FXML private TableColumn<BookVO, String> isbn;
	@FXML private TableColumn<BookVO, String> title;
	@FXML private TableColumn<BookVO, Integer> price;
	@FXML private TableColumn<BookVO, String> author;
	
	private String selectedISBN;
	
	public void searchBookByKeyword() {
		BookService service = new BookService();
		
		//return된 List를 ObservableList로 변환
		ObservableList<BookVO> list =
				FXCollections.observableList(service.searchBookByKeyword(textField.getText()));
		
		tableView.setItems(list);
	}
	
	public void deleteSelectedBook() {
		BookService service = new BookService();

		ObservableList<BookVO> list =
				FXCollections.observableList(service.deleteSelectedBook(selectedISBN, textField.getText())); 
		tableView.setItems(list);
	}
	
	public void updateSelectedBook(BookVO book) {
		BookService service = new BookService();

		ObservableList<BookVO> list =
				FXCollections.observableList(service.updateSelectedBook(book, textField.getText())); 
		tableView.setItems(list);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TableView의 어떤 컬럼이 VO의 어떤 필드와 매핑 되는지 설정
		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		
		
		// 1. 책 제목 수정
		// 테이블 뷰 편집 가능하도록 설정
		tableView.setEditable(true);
		// 제목 컬럼을 더블 클릭시 Textfield가 되어 수정가능하도록 함
        title.setCellFactory(TextFieldTableCell.forTableColumn());
        title.setOnEditCommit(event -> {
            BookVO book = event.getTableView().getItems().get(event.getTablePosition().getRow());
            book.setBtitle(event.getNewValue());
            updateSelectedBook(book);
        });

        
		
		// TableView의 각 row에 대해 처리
		tableView.setRowFactory(e -> {
			// TableView의 row가 만들어질 때마다 실행하도록 함 
			TableRow<BookVO> row = new TableRow<>();
			
			// row가 click됐을 대 event 처리
			row.setOnMouseClicked(e1 -> {
				// row가 한번 클릭 됐고, 비어 있지 않을 때
				if(e1.getClickCount()==1 && !row.isEmpty()) {
					//VO에 해당 내용 가지고 오기
					BookVO book = row.getItem();
					
					//선택된 ISBN 값을 저장
					selectedISBN = book.getBisbn();
				}
			});
			
			return row;
		});
		
		
		// 2. 키워드로 도서 검색하기
		// 2-1. 검색 버튼 이용
		searchBtn.setOnAction(e -> {
			searchBookByKeyword();		
		});
		
		// 2-2. enter 키 이용
		textField.setOnAction(e -> {
			searchBookByKeyword();		
		});
		
		// 3. 선택된 행의 도서 삭제하기
		deleteBtn.setOnAction(e -> {
			deleteSelectedBook();
		});
		
	}
}
