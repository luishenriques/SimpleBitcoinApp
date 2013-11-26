package br.bitcoin.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.bitcoin.utils.ConnectionHelper;

import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;

@WebServlet("/enderecos")
public class EnderecosServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BitcoinJSONRPCClient bc = ConnectionHelper.getClient();
		response.setContentType("text/html");
		try {
			List<String> list = bc.getAddressesByAccount("");
			request.setAttribute("enderecos", list);
			for (String a : list) {
				System.out.println(a);
			}
		} catch (BitcoinException e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enderecos.jsp");
		dispatcher.forward(request, response);
	}

}
