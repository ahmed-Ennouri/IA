package org.ia.pharmacies.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ia.pharmacies.algo.Graph;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private Graph graph;

    public Controller() {
    }
    
    @Override
    public void init() throws ServletException {
    	graph = new Graph();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			if(request.getParameter("source")!=null && request.getParameter("target")!=null) {
				
				String source =request.getParameter("source");
				String target=request.getParameter("target");
				System.out.println("hvhfez");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
