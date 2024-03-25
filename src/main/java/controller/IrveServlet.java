package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IrveDAO;
import model.Irve;

/**
 * Servlet implementation class IrveServlet
 */
@WebServlet(
		name = "IrveSerlet",
		urlPatterns = "/ma-carte")
public class IrveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IrveDAO dao = new IrveDAO();
	private void processRequest(
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		

		        String irveRequest = request.getParameter("request");
		        if (irveRequest == null) {
		        	ArrayList<Irve> list = dao.getList();
		        	//Irve list = dao.get("Grupo Easycharger");
		        	if(list != null)
		        		request.setAttribute("listIrve", list);
		        	else
		        		System.out.println("CHECKPOINT 1");
		        }

		        RequestDispatcher dispatcher = request.getRequestDispatcher(
		          "macarte.jsp");
		        dispatcher.forward(request, response);
		    }

	@Override
    protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

        processRequest(request, response);
    }

}
