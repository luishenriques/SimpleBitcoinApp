package br.bitcoin.utils;

import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;

public class ConnectionHelper {

	public final static String user = "admin1";
	public final static String password = "123";
	public final static String connectionUrl = "http://" + user + ":" + password + "@127.0.0.1:19001";

	public static BitcoinJSONRPCClient getClient() throws MalformedURLException {

		return new BitcoinJSONRPCClient(connectionUrl);

	}

}
