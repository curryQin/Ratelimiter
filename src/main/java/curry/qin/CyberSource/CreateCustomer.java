package curry.qin.CyberSource;

import Api.CustomerApi;
import Invokers.ApiClient;
import Model.PostCustomerRequest;
import Model.TmsV2CustomersResponse;
import Model.Tmsv2customersBuyerInformation;
import Model.Tmsv2customersClientReferenceInformation;
import Model.Tmsv2customersMerchantDefinedInformation;
import com.cybersource.authsdk.core.MerchantConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/***
 * 注册用户到Cybersource 生成用户CustomerToken
 */
public class CreateCustomer {
	private static String responseCode = null;
	private static String status = null;
	private static Properties merchantProp;

	public static void main(String args[]) throws Exception {
		// Accept required parameters from args[] and pass to run.
		run();
		//ADFE40D503EFE152E05341588E0A6E7F
	}
	public static TmsV2CustomersResponse run() {
	
		PostCustomerRequest requestObj = new PostCustomerRequest();

		Tmsv2customersBuyerInformation buyerInformation = new Tmsv2customersBuyerInformation();
		buyerInformation.merchantCustomerID("curryQin");
		buyerInformation.email("361121781@qq.com");
		requestObj.buyerInformation(buyerInformation);

		Tmsv2customersClientReferenceInformation clientReferenceInformation = new Tmsv2customersClientReferenceInformation();
		clientReferenceInformation.code("TC50171_3");
		requestObj.clientReferenceInformation(clientReferenceInformation);


		List <Tmsv2customersMerchantDefinedInformation> merchantDefinedInformation =  new ArrayList <Tmsv2customersMerchantDefinedInformation>();
		Tmsv2customersMerchantDefinedInformation merchantDefinedInformation1 = new Tmsv2customersMerchantDefinedInformation();
		merchantDefinedInformation1.name("data1");
		merchantDefinedInformation1.value("Your customer data");
		merchantDefinedInformation.add(merchantDefinedInformation1);

		requestObj.merchantDefinedInformation(merchantDefinedInformation);

		TmsV2CustomersResponse result = null;
		try {
			merchantProp = Configuration.getMerchantDetails();
			ApiClient apiClient = new ApiClient();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			apiClient.merchantConfig = merchantConfig;

			CustomerApi apiInstance = new CustomerApi(apiClient);
			result = apiInstance.postCustomer(requestObj, null);

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