package br.bitcoin.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;

@WebServlet("/balance")
public class CheckBalanceServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BitcoinJSONRPCClient bc = new BitcoinJSONRPCClient("http://admin1:123@127.0.0.1:19001");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			out.println("<!DOCTYPE html>\n" + "<html>\n" + "<head><title>A Test Servlet</title></head>\n" + "<body bgcolor=\"#fdf5e6\">\n"
					+ "<h1>Test</h1>\n" + "<p>Simple servlet for testing.</p>\n" + bc.getBalance() + "</body></html>");
		} catch (BitcoinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
