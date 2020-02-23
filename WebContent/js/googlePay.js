

let googlePayClient;
function onGooglePayLoaded() {
  googlePayClient = new google.payments.api.PaymentsClient({
    environment: 'TEST'
  });

	googlePayClient.isReadyToPay(googlePayBaseConfiguration)
	  .then(function(response) {
	    if(response.result) {
	      createAndAddButton();
	    } else {
	      alert("Unable to pay using Google Pay");
	    }
	  }).catch(function(err) {
	    console.error("Error determining readiness to use Google Pay: ", err);
	  });
}

		const baseCardPaymentMethod = {
		  type: 'CARD',
		  parameters: {
		    allowedCardNetworks: ['VISA','MASTERCARD'],
		    allowedAuthMethods: ['PAN_ONLY','CRYPTOGRAM_3DS']
		  }
		};


		const googlePayBaseConfiguration = {
		  apiVersion: 2,
		  apiVersionMinor: 0,
		  allowedPaymentMethods: [baseCardPaymentMethod]
		};
		
		function createAndAddButton() {

			  const googlePayButton = googlePayClient.createButton({

			    // currently defaults to black if default or omitted
			    buttonColor: 'default',

			    // defaults to long if omitted
			    buttonType: 'long',

			    onClick: onGooglePaymentsButtonClicked
			  });

			  document.getElementById('buy-now').appendChild(googlePayButton);
			}

			function onGooglePaymentsButtonClicked() {
				const tokenizationSpecification = {
						  type: 'PAYMENT_GATEWAY',
						  parameters: {
						    gateway: 'example',
						    gatewayMerchantId: 'gatewayMerchantId'
						  }
						};
				const cardPaymentMethod = {
						  type: 'CARD',
						  tokenizationSpecification: tokenizationSpecification,
						  parameters: {
						    allowedCardNetworks: ['VISA','MASTERCARD'],
						    allowedAuthMethods: ['PAN_ONLY','CRYPTOGRAM_3DS'],
						    billingAddressRequired: true,
						    billingAddressParameters: {
						      format: 'FULL',
						      phoneNumberRequired: true
						    }
						  }
						};
				
				const transactionInfo = {
						  totalPriceStatus: 'FINAL',
						  totalPrice: document.getElementById("role").value,
						  currencyCode: 'EUR'
						};
				const merchantInfo = {
						  // merchantId: '01234567890123456789', Only in PRODUCTION
						  merchantName: 'in modo sicuro'
						};
				const paymentDataRequest = Object.assign({}, googlePayBaseConfiguration, {
					  allowedPaymentMethods: [cardPaymentMethod],
					  transactionInfo: transactionInfo,
					  merchantInfo: merchantInfo   
					});
				googlePayClient
				  .loadPaymentData(paymentDataRequest)
				  .then(function(paymentData) {
				    processPayment(paymentData);
				  }).catch(function(err) {
				    // Log error: { statusCode: CANCELED || DEVELOPER_ERROR }
				  });
				
				paymentDataRequest.shippingAddressRequired = true;
				paymentDataRequest.shippingOptionRequired = true;
				paymentDataRequest.callbackIntents = ['SHIPPING_OPTION'];
				paymentDataRequest.shippingOptionParameters =  shippingOptionParameters;
			}
			
			
			 PaymentData = {
					 "apiVersionMinor": 0,
					  "apiVersion": 2,
					  "paymentMethodData": {
					    "description": "Visa •••• 1234",
					    "tokenizationData": {
					      "type": "PAYMENT_GATEWAY",
					      "token": "examplePaymentMethodToken"
					    },
					    "type": "CARD",
					    "info": {
					      "cardNetwork": "VISA",
					      "cardDetails": "1234",
					     
					    }
					  }
			 }
			 
			 function payment1(event){
				    $.ajax({
				       type: "GET",
				       url: "paym",
				       success:function(){
				    	   alert("Pagamento avvenuto con successo");
				    	   window.location.replace("index.jsp");
				    	   

				       },
				        error : function () {
				          alert("Inserisci almeno un prodotto nel carrello prima");
				     	   window.location.replace("checkout.jsp");
				    	   

				        }
				    });
				}
			 
			 function processPayment(paymentData) {
				  // TODO: Send a POST request to your processor with the payload
				  // https://us-central1-devrel-payments.cloudfunctions.net/google-pay-server 
				  // Sorry, this is out-of-scope for this codelab.
				  return new Promise(function(resolve, reject) {
				    // @todo pass payment token to your gateway to process payment
				    const paymentToken = paymentData.paymentMethodData.tokenizationData.token;
				    console.log('mock send token ' + paymentToken + ' to payment processor');
				    setTimeout(function() {
				      console.log('mock response from processor');
				      payment1(event);
				      resolve({});
				    }, 800);
				  });
				}
			 
			 const shippingOptionParameters = {
					  shippingOptions: [
					    {
					      id: 'Spedizione1',
					      label: '1,99 euro: Spedizione standard',
					      description: 'Entro tra 5-6 giorni.'
					    },
					    {
					      id: 'Spedizione2',
					      label: '3,99 euro: Spedizione tracciata',
					      description: 'Entro 2-3 giorni.'
					    },
					    {
					      id: 'Spedizione3',
					      label: '10 euro: Spedizione Express',
					      description: 'Entro 24 ore.'
					    }
					  ]
					};

					// Shipping surcharges mapped to the IDs above.
					const shippingSurcharges = {
					  'Spedizione1': 1.99,
					  'Spedizione2': 3.99,
					  'Spedizione3': 10
					};

		