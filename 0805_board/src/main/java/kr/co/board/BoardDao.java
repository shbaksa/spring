package kr.co.board;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class BoardDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";
	String id, name, pwd, title, content;

	public BoardDao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String db = "jdbc:mysql://localhost:3306/second";
		conn = DriverManager.getConnection(db, "root", "1234");
	}

	/*
	 * public void write_ok(HttpServletRequest request) throws Exception{
	 * 
	 * title = request.getParameter("title"); name = request.getParameter("name");
	 * pwd = request.getParameter("pwd"); content = request.getParameter("content");
	 * 
	 * sql =
	 * "insert into board(title,name,pwd,content,writeday) values(?,?,?,?,now())";
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, title);
	 * pstmt.setString(2, name); pstmt.setString(3, pwd); pstmt.setString(4,
	 * content);
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * pstmt.close(); conn.close();
	 * 
	 * }
	 */

	public String write_ok(BoardDto bdto) throws Exception {

		sql = "insert into board(title,name,pwd,content,writeday) values(?,?,?,?,now())";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bdto.getTitle());
		pstmt.setString(2, bdto.getName());
		pstmt.setString(3, bdto.getPwd());
		pstmt.setString(4, bdto.getContent());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();

		return "redirect:/list";
	}

	public String list(Model model) throws Exception {

		sql = "select * from board order by id desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		ArrayList<BoardDto> blist = new ArrayList<BoardDto>();

		while (rs.next()) {
			BoardDto bdto = new BoardDto();
			bdto.setId(rs.getInt("id"));
			bdto.setName(rs.getString("name"));
			bdto.setTitle(rs.getString("title"));
			bdto.setWriteday(rs.getString("writeday"));
			bdto.setReadnum(rs.getInt("readnum"));

			blist.add(bdto);
		}

		model.addAttribute("blist", blist);

		pstmt.close();
		conn.close();

		return "/list";

	}

	public String content(HttpServletRequest request, Model model) throws Exception {

		id = request.getParameter("id");

		sql = "select * from board where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		rs.next();

		BoardDto bdto = new BoardDto();

		bdto.setContent(rs.getString("content").replace("\r\n", "<br>"));
		bdto.setId(rs.getInt("id"));
		bdto.setName(rs.getString("name"));
		bdto.setReadnum(rs.getInt("readnum"));
		bdto.setTitle(rs.getString("title"));
		bdto.setWriteday(rs.getString("writeday"));

		model.addAttribute("bdto", bdto);

		return "/content";

	}

	/*
	 * public void readnum(HttpServletRequest request) throws Exception{
	 * 
	 * id = request.getParameter("id");
	 * 
	 * sql = "update board set readnum=readnum+1 where id=?"; pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, id);
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * pstmt.close(); conn.close();
	 * 
	 * //return "redirect:/content?id="+id; }
	 */

	public String readnum(HttpServletRequest request) throws Exception {

		id = request.getParameter("id");

		sql = "update board set readnum=readnum+1 where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();

		return "redirect:/content?id=" + id;
	}

	public String update(HttpServletRequest request, Model model) throws Exception {

		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		sql = "select * from board where id=?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		rs.next();

		String dbpwd = rs.getString("pwd");

		if (pwd.equals(dbpwd)) {
			BoardDto bdto = new BoardDto();
			bdto.setContent(rs.getString("content"));
			bdto.setId(rs.getInt("id"));
			bdto.setName(rs.getString("name"));
			bdto.setTitle(rs.getString("title"));

			model.addAttribute("bdto", bdto);

			return "/update";
		} else
			return "redirect:/content?id=" + id;

	}

	public String update_ok(BoardDto bdto) throws Exception {

		sql = "update board set title=?, name=?, content=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bdto.getTitle());
		pstmt.setString(2, bdto.getName());
		pstmt.setString(3, bdto.getContent());
		pstmt.setInt(4, bdto.getId());
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();

		return "redirect:/content?id=" + bdto.getId();

	}

	public String delete(HttpServletRequest request) throws Exception {

		id = request.getParameter("id");
		pwd = request.getParameter("pwd");

		sql = "select pwd from board where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		rs.next();

		String dbpwd = rs.getString("pwd");

		if (pwd.equals(dbpwd)) {

			sql = "delete from board where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

			return "redirect:/list";
		} else
			return "redirect:/content?id=" + id;

	}

}
