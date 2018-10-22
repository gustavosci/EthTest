import java.io.IOException;
import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

public class AddValue {

	public static void main(String args[]) {
		Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/b899135495c846c3b06c3d6882d48e47")); // defaults
																													// to
																													// http://localhost:8545/
		Web3ClientVersion web3ClientVersion = null;
		try {
			web3ClientVersion = web3.web3ClientVersion().send();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
		System.out.println(clientVersion);

		Credentials credentials;

		try {

			String sk = "D00A095AE2EE9657D57BD5F54D3D2022547350F46EF7C7A7C145BE9356B3B86A".toLowerCase();

			// Usar sua chave publica
			credentials = Credentials.create(sk);

			//Hello novo = Hello.deploy(web3, credentials, new BigInteger("100000000000"), new BigInteger("3000000")).send();
			//System.out.println(novo.getContractAddress());

			// Para carregar o contrato existente
			Hello novo = Hello.load("0x979969ffe18360a34b14dc2a708896674f69a6f4", web3,
			credentials, new BigInteger("5000"), new BigInteger("300000"));
			System.out.println(novo.getContractAddress());
			
			System.out.println(novo.getValor().send());

			// Interagindo com o contrato
			TransactionReceipt tR = novo.setValor("Oi 3").send();
			System.out.println(novo.getValor().send());

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		web3.shutdown();

	}

}
