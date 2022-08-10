package kr.co.board_page.dto;

public class BoardDto {
	
	private int id,readnum,page,pstart,pend,chong;
	private String name,title,content,pwd,writeday;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPstart() {
		return pstart;
	}
	public void setPstart(int pstart) {
		this.pstart = pstart;
	}
	public int getPend() {
		return pend;
	}
	public void setPend(int pend) {
		this.pend = pend;
	}
	public int getChong() {
		return chong;
	}
	public void setChong(int chong) {
		this.chong = chong;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReadnum() {
		return readnum;
	}
	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
}
