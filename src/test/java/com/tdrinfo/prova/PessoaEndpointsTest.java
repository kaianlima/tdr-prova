package com.tdrinfo.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PessoaEndpointsTest {

	private static String url;
	
	@BeforeAll
	static void testCreatePessoa() {
		url = "http://localhost:8080/pessoas/";
	}

	// Caso de Sucesso
	@Test
	public void testGetPessoas() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(url);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
	}

	// Caso de Erro

	@Test
	public void testDadogivenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
	  throws ClientProtocolException, IOException {
	 
	    // Given
	    Long id = (long) 9124124;
	    HttpUriRequest request = new HttpGet(url + id);

	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

	    // Then
	    assertEquals(HttpStatus.SC_NOT_FOUND, httpResponse.getStatusLine().getStatusCode());
	}

}
