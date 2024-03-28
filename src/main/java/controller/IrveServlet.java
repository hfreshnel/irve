package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		
				String req = request.getReader().readLine();
				System.out.println(req);
	        	//ArrayList<Irve> list = dao.getList();
				ArrayList<Irve> list = dao.getList(req);
				
	        	System.out.println("CHECKPOINT 1");

	            // Configurer le type de contenu de la réponse comme JSON
	            response.setContentType("application/json");
	            JSONArray jArray = new JSONArray(list);
	            JSONObject jsonObject = new JSONObject();
	            try {
					jsonObject.put("listIRVE", jArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            // Écrire les données à envoyer dans la réponse
	            response.getWriter().print(jsonObject);
	            response.getWriter().flush();
	            //response.getWriter().write(list.toJSON().toString());
	        	/*if(list != null)
	        		request.setAttribute("listIrve", list);
	        	else
	        		System.out.println("CHECKPOINT 2");
	        	
		        RequestDispatcher dispatcher = request.getRequestDispatcher(
		          "macarte.jsp");
		        dispatcher.forward(request, response);*/
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
