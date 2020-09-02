package curry.qin.CyberSource;

import Api.InstrumentIdentifierApi;
import Invokers.ApiClient;
import Model.PostInstrumentIdentifierRequest;
import Model.Tmsv2customersEmbeddedDefaultPaymentInstrumentEmbeddedInstrumentIdentifier;
import Model.Tmsv2customersEmbeddedDefaultPaymentInstrumentEmbeddedInstrumentIdentifierBankAccount;
import com.cybersource.authsdk.core.MerchantConfig;

import java.util.Properties;

/***
 * 根据银行卡号创建Instrument Identifier
 */
public class CreateInstrumentIdentifierBankAccount {
	private static String responseCode = null;
	private static String status = null;
	private static Properties merchantProp;

	public static void main(String args[]) throws Exception {
		run();
	}

	public static Tmsv2customersEmbeddedDefaultPaymentInstrumentEmbeddedInstrumentIdentifier run() {
		String profileid = "93B32398-AD51-4CC2-A682-EA3E93614EB1";
		PostInstrumentIdentifierRequest requestObj = new PostInstrumentIdentifierRequest();

		Tmsv2customersEmbeddedDefaultPaymentInstrumentEmbeddedInstrumentIdentifierBankAccount bankAccount = new Tmsv2customersEmbeddedDefaultPaymentInstrumentEmbeddedInstrumentIdentifierBankAccount();
		bankAccount.number("4100");
		bankAccount.routingNumber("071923284");
		requestObj.bankAccount(bankAccount);

		Tmsv2customersEmbeddedDefaultPaymentInstrumentEmbeddedInstrumentIdentifier result = null;
		try {
			merchantProp = Configuration.getMerchantDetails();
			ApiClient apiClient = new ApiClient();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			apiClient.merchantConfig = merchantConfig;

			InstrumentIdentifierApi apiInstance = new InstrumentIdentifierApi(apiClient);
			result = apiInstance.postInstrumentIdentifier(requestObj, profileid);

			responseCode = apiClient.responseCode;
			status = apiClient.status;
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + status);
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return result;
	}
}