package kpi.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpi.model.Model;
import kpi.view.View;


/**
 * Servlet implementation class JavaGameServlet
 */
@WebServlet("/JavaGameServlet")
public class JavaGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
														throws ServletException, IOException {

		if(request.getParameter("attempt") == null) {
			String name = request.getParameter("name");
			int minValue = Integer.parseInt(request.getParameter("minValue"));
			int maxValue = Integer.parseInt(request.getParameter("maxValue"));
		
			Model model = new Model();
	
			int rand = model.rand(minValue, maxValue);

			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("minValue", model.getMinValue());
			request.getSession().setAttribute("maxValue", model.getMaxValue());
			request.getSession().setAttribute("randValue", rand);
			request.getSession().setAttribute("model", model);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/game.jsp");
			dispatcher.forward(request, response);
		} else {
			Model model = (Model)request.getSession().getAttribute("model");
			int attempt = Integer.parseInt(request.getParameter("attempt"));
			model.addAttempt(attempt);
			if(isEqualsRandom(model, request)) {
				request.getSession(false).removeAttribute("hint");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/congratulation.jsp");
				dispatcher.forward(request, response);
				//response.sendRedirect("/WEB-INF/views/congratulation.jsp");
			} else {
				request.getSession().setAttribute("minValue", model.getMinValue());
				request.getSession().setAttribute("maxValue", model.getMaxValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/game.jsp");
				dispatcher.forward(request, response);
				//response.sendRedirect("/WEB-INF/views/game.jsp");
			}
		}		
	}
	
	public boolean isEqualsRandom(Model model, HttpServletRequest request) {
        if (model.getLastAttempt() < model.getRandomValue()) {
        	request.getSession().setAttribute("hint", View.LESS_THAN_RANDOM);
            model.setMinValue(model.getLastAttempt());
            return false;
        } else if (model.getLastAttempt() > model.getRandomValue()){
        	request.getSession().setAttribute("hint", View.MORE_THAN_RANDOM);
            model.setMaxValue(model.getLastAttempt());
            return false;
        } else {
            return true;
        }
    }
}
