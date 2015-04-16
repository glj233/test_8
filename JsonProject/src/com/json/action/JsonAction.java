package com.json.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.service.JsonService;
import com.json.tools.JsonTools;

/**
 * Servlet implementation class JsonAction
 */
@WebServlet("/JsonAction")
public class JsonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JsonService service;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String action_flag=request.getParameter("action_flag");
		String jsonString=""; 
		if (action_flag.equals("person")) {
			System.out.println("收到person请求");
			jsonString = JsonTools.createJsonString("person",
					service.getPerson());
		}
		if (action_flag.equals("listperson")) {
			System.out.println("收到listperson请求");
			jsonString = JsonTools.createJsonString("listperson",
					service.getListPerson());
		}
		if (action_flag.equals("liststring")) {
			System.out.println("收到liststring请求");
			jsonString = JsonTools.createJsonString("liststring",
					service.getListString());
		}
		if (action_flag.equals("listmap")) {
			System.out.println("收到listmap请求");
			jsonString = JsonTools.createJsonString("listmap",
					service.getListMap());
		}

		out.println(jsonString);
		out.flush();
		out.close();
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		service = new JsonService();
	}

}
