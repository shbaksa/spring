package kr.co.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class BoardDao {

	Connection conn;
	PreparedStatement pstmt;
    public BoardDao() throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
        String db="jdbc:mysql://localhost:3306/second";
        conn=DriverManager.getConnection(db,"root","1234");
    }
	/*public void write_ok(HttpServletRequest request) throws Exception
	{
		// request
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String pwd=request.getParameter("pwd");
		String content=request.getParameter("content");
		
		// 쿼리 생성
		String sql="insert into board(name,title,pwd,content,writeday) values(?,?,?,?,now())";
		
		// 심부름꾼생성
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, title);
		pstmt.setString(3, pwd);
		pstmt.setString(4, content);
		
		// 쿼리 실행
		pstmt.executeUpdate();
		
		// close
		pstmt.close();
		conn.close();
		
	}*/
    
    public String write_ok(BoardDto bdto) throws Exception
	{
		
		// 쿼리 생성
		String sql="insert into board(name,title,pwd,content,writeday) values(?,?,?,?,now())";
		
		// 심부름꾼생성
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, bdto.getName());
		pstmt.setString(2, bdto.getTitle());
		pstmt.setString(3, bdto.getPwd());
		pstmt.setString(4, bdto.getContent());
		
		// 쿼리 실행
		pstmt.executeUpdate();
		
		// close
		pstmt.close();
		conn.close();
		
		return "redirect:/list";
	}
    
    public String list(Model model) throws Exception
    {
    	String sql="select * from board order by id desc";
    	
    	pstmt=conn.prepareStatement(sql);
    	
    	ResultSet rs=pstmt.executeQuery();
    	
    	// rs => dto => ArrayList
    	ArrayList<BoardDto> list=new ArrayList<BoardDto>();
    	
    	while(rs.next()) 
    	{
    		BoardDto bdto=new BoardDto();
    		bdto.setId(rs.getInt("id"));
      		bdto.setName(rs.getString("name"));
    		bdto.setReadnum(rs.getInt("readnum"));
    		bdto.setTitle(rs.getString("title"));
    		bdto.setWriteday(rs.getString("writeday"));
    		
    		list.add(bdto);
    	}
    	
        model.addAttribute("list",list);
		
		return "/list";
    }
    
    public String readnum(HttpServletRequest request) throws Exception
    {
    	// 1증가 시킨다.
    	// request
    	String id=request.getParameter("id");
    	
    	// 쿼리 생성
    	String sql="update board set readnum=readnum+1 where id=?";
    	
    	// 심부름꾼 생성
    	pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, id);
    	
    	// 쿼리 실행
    	//pstmt.executeUpdate();
    	
    	// close
    	//pstmt.close();
    	//conn.close();
    	
    	System.out.println(id);
    	// return
    	return "redirect:/content?id="+id;
    }
    
    public String content(HttpServletRequest request,Model model) throws Exception
    {
    	// request
    	String id=request.getParameter("id");
    	
    	// 쿼리 생성
    	String sql="select * from board where id=?";
    	
    	// 심부름꾼 생성
    	pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1, id);
    	
    	// 쿼리 실행
    	ResultSet rs=pstmt.executeQuery();
    	rs.next();
    	
    	// 하나의 레코드 => dto
    	BoardDto bdto=new BoardDto();
    	bdto.setId(rs.getInt("id"));
  		bdto.setName(rs.getString("name"));
		bdto.setReadnum(rs.getInt("readnum"));
		bdto.setTitle(rs.getString("title"));
		bdto.setWriteday(rs.getString("writeday"));
		bdto.setContent(rs.getString("content").replace("\r\n","<br>"));
		
		model.addAttribute("bdto",bdto);
		
		return "/content";
    }
     
   public String delete(HttpServletRequest request) throws Exception
   {
	   String id=request.getParameter("id");
	   String sql="delete from board where id=?";
	   pstmt=conn.prepareStatement(sql);
	   pstmt.setString(1,id);
	   
	   pstmt.executeUpdate();
	   
	   pstmt.close();
	   conn.close();

	   return "redirect:/list";
   }
    
   public String update(HttpServletRequest request,Model model) throws Exception
   {
   	// request
   	String id=request.getParameter("id");
   	
   	// 쿼리 생성
   	String sql="select * from board where id=?";
   	
   	// 심부름꾼 생성
   	pstmt=conn.prepareStatement(sql);
   	pstmt.setString(1, id);
   	
   	// 쿼리 실행
   	ResultSet rs=pstmt.executeQuery();
   	rs.next();
   	
   	// 하나의 레코드 => dto
   	BoardDto bdto=new BoardDto();
   	bdto.setId(rs.getInt("id"));
 	bdto.setName(rs.getString("name"));
	bdto.setReadnum(rs.getInt("readnum"));
	bdto.setTitle(rs.getString("title"));
	bdto.setWriteday(rs.getString("writeday"));
	bdto.setContent(rs.getString("content"));
		
	model.addAttribute("bdto",bdto);
		
	return "/update";	
   }
   
   public String update_ok(BoardDto bdto) throws Exception
   {
	   String sql="update board set title=?, name=?, content=? where id=?";
	   pstmt=conn.prepareStatement(sql);
	   pstmt.setString(1, bdto.getTitle());
	   pstmt.setString(2, bdto.getName());
	   pstmt.setString(3, bdto.getContent());
	   pstmt.setInt(4, bdto.getId());
	   
	   pstmt.executeUpdate();
	   
	   pstmt.close();
	   conn.close();
	   
	   return "redirect:/content?id="+bdto.getId();
   } 
    
}







