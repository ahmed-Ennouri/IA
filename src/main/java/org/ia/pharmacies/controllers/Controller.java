package org.ia.pharmacies.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ia.pharmacies.algo.Graph;
import org.ia.pharmacies.models.Pharmacie;

import com.google.gson.Gson;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private Graph graph;
	private Gson gson;
	
	public void init() throws ServletException {
		graph = new Graph();
		gson = new Gson();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		if(request.getParameter("source")!=null && request.getParameter("target")!=null) {
				String source =request.getParameter("source");
				String target=request.getParameter("target");
				List<Pharmacie> shortestPath = graph.findAndPrintShortestPath(source, target);
				
				String pharmacieJsonString = this.gson.toJson(shortestPath);

		        PrintWriter out = response.getWriter();
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        out.print(pharmacieJsonString);
		        out.flush();   
		}
	}


}
