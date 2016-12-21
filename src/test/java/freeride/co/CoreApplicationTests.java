package freeride.co;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Basic integration tests for {@link CoreApplicationTests}.
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class CoreApplicationTests {

	@LocalServerPort
	private String port;

	@Autowired
	private ApplicationContext context;

	@BeforeClass
	public static void setUp() {

		try {
			// setup ssl context to ignore certificate errors
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509TrustManager() {

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
											   String authType) throws java.security.cert.CertificateException {
				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
											   String authType) throws java.security.cert.CertificateException {
				}

				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLContext.setDefault(ctx);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Test
	public void testHello() throws Exception {
		RestTemplate template = new RestTemplate();
		final MySimpleClientHttpRequestFactory factory = new MySimpleClientHttpRequestFactory(
				new HostnameVerifier() {

					@Override
					public boolean verify(final String hostname,
										  final SSLSession session) {
						return true; // these guys are alright by me...
					}
				});
		template.setRequestFactory(factory);

		ResponseEntity<String> httpsEntity = template
				.getForEntity("https://localhost:" + this.port + "/hello", String.class);
		assertThat(httpsEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(httpsEntity.getBody()).isEqualTo("hello");

	}

	/**
	 * Http Request Factory for ignoring SSL hostname errors. Not for production use!
	 */
	class MySimpleClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

		private final HostnameVerifier verifier;

		public MySimpleClientHttpRequestFactory(final HostnameVerifier verifier) {
			this.verifier = verifier;
		}

		@Override
		protected void prepareConnection(final HttpURLConnection connection,
										 final String httpMethod) throws IOException {
			if (connection instanceof HttpsURLConnection) {
				((HttpsURLConnection) connection).setHostnameVerifier(this.verifier);
			}
			super.prepareConnection(connection, httpMethod);
		}
	}

}