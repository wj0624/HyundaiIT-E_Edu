package booksearch.vo;
//package 분리


public class BookVO {
	// 당연히 테이블 이름으로 짓는 것
	// 요즘 트렌드는 뒤에 VO 나 DTO 를 붙임
	private String bisbn;
	private String btitle;
	private int bprice;
	private String bauthor;
	// private field 로 모든 컬럼을 선언해주는 게 기본

	public BookVO(String bisbn, String btitle, int bprice, String bauthor) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bauthor = bauthor;
	}
	
	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	
}
