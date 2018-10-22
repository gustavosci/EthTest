import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class Acesso {

	public static void main(String[] args) {
		//Conectar no Infura
			Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/b899135495c846c3b06c3d6882d48e47"));
			try
			{
				System.out.println(web3.web3ClientVersion().send().getWeb3ClientVersion());
			}
			catch(Exception e)
			{
				System.err.println(e);
				System.exit(1);
			}
	
			web3.shutdown(); //Sempre fechar a conexão
			System.exit(0);
	}

}
