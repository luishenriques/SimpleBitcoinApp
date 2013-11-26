package br.bitcoin.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.bitcoin.transferobjects.TransacaoDto;
import br.bitcoin.utils.ConnectionHelper;

import com.azazar.bitcoin.jsonrpcclient.Bitcoin.Transaction;
import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BitcoinJSONRPCClient bc = ConnectionHelper.getClient();
		response.setContentType("text/html");

		// Por causa da estrutura do objeto retornado, teremos que refazer a lista usando um Dto para utilizarmos EL na
		// página JSP
		List<TransacaoDto> transacoes = new ArrayList<TransacaoDto>();
		try {
			List<Transaction> transacoesOriginal = bc.listTransactions();
			for (Transaction transaction : transacoesOriginal) {
				transacoes.add(new TransacaoDto(transaction.time(),transaction.address(),transaction.amount(),transaction.confirmations()));
			}
			request.setAttribute("transacoes", transacoes);

		} catch (BitcoinException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/transacoes.jsp");
		dispatcher.forward(request, response);
	}

}
