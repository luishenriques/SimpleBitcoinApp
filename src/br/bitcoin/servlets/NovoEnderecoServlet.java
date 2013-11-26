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

@WebServlet("/novoendereco")
public class NovoEnderecoServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BitcoinJSONRPCClient bc = ConnectionHelper.getClient();
		response.setContentType("text/html");
		try {
			String novoEndereco = bc.getNewAddress();
			request.setAttribute("endereco", novoEndereco);
		} catch (BitcoinException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/novo_endereco.jsp");
		dispatcher.forward(request, response);
	}

}
