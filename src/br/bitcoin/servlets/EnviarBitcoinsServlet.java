package br.bitcoin.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.bitcoin.utils.ConnectionHelper;

import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;

@WebServlet("/enviar")
public class EnviarBitcoinsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BitcoinJSONRPCClient bc = ConnectionHelper.getClient();
		response.setContentType("text/html");
		String endereco = request.getParameter("endereco");
		String valor = request.getParameter("valor");
		if (endereco == null || valor == null || endereco.equals("") || valor.equals("")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enviar.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
				String txid = bc.sendToAddress(endereco, new Double(valor));
				request.setAttribute("txid", txid);
			} catch (BitcoinException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enviado.jsp");
			dispatcher.forward(request, response);
		}

	}
}