package controller.user;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.java.javaURLContextFactory;

import model.nonTables.ProdottoAggregato;
import model.tables.Pagamento;
import persistence.DAOFactory;
import persistence.DBManager;
import persistence.dao.OrdineDao;
import persistence.dao.ProdottoDao;

@WebServlet(value = "/paym", name = "paym")
public class payment extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4725397173656796295L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOFactory factory = DBManager.getInstance().getDAOFactory();

		Date d = new Date(new java.util.Date().getTime());
			
		Pagamento p = new Pagamento();
		p.setid_ordine((Integer) request.getSession().getAttribute("idordine"));
		p.setdata_pagamento(d);
		p.setImporto((Integer) request.getSession().getAttribute("totp"));
		
		factory.getPagamentoDao().save(p);

		factory.getOrdineDao().pay((Integer) request.getSession().getAttribute("userId"));
			
		response.setStatus(201);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}