//package com.hashedin.test;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//
//public class TestMetrics {
//
//	public static void main(String[] args) {
//		 
//		TestMetrics test = new TestMetrics();
//       // test.getAlertResponse();
//       // test.getMatricsResponse();
//    }
// 
//    private void getMatricsResponse() {
//        try {
// 
//            Client client = Client.create();
//            WebResource webResource2 = client.resource("http://localhost:8080/api/metrics");
//            ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
//            if (response2.getStatus() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
//            }
// 
//            String output2 = response2.getEntity(String.class);
//            System.out.println("\n============getMatricsResponse============");
//            System.out.println(output2);
// 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
// 
//    private void getAlertResponse() {
//        try {
// 
//            Client client = Client.create();
//            WebResource webResource = client.resource(" http://localhost:8080/api/alerts");
//            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
//            if (response.getStatus() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//            }
// 
//            String output = response.getEntity(String.class);
//            System.out.println("============getAlertResponse============");
//            System.out.println(output);
// 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
