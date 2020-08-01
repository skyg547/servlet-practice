package jstlel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class _01Servlet
 */
public class _01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int iVal = 10;
		long lVal = 1234456789;
		float fVal = 3.14f;
		boolean bVal = true;
		String sVal = "가나다라마바사";
		
		request.setAttribute("ival", iVal);
		request.setAttribute("lval", lVal);
		request.setAttribute("fval", fVal);
		request.setAttribute("bval", bVal);
		request.setAttribute("sval", sVal);
		
		Object obj = null;
		UserVo vo = new UserVo();
		vo.setName("gh");
		vo.setNo(10L);
		request.setAttribute("obj", obj);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("ival", iVal);
		
		
		request.getRequestDispatcher("WEB-INF/views/01.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
