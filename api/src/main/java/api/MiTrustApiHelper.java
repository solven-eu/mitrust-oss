package io.mitrust.oss.api;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriTemplateHandler;

/**
 * Various methods to help interacting with MiTrust API
 * 
 * @author Benoit Lacelle
 *
 */
public class MiTrustApiHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(MiTrustApiHelper.class);

	protected MiTrustApiHelper() {
		// hidden
	}

	public static String basicHeaderValue(Map<?, String> credentials) {
		String valueAsString = credentials.get("client_id") + ":" + credentials.get("client_secret");
		return "Basic " + Base64.getEncoder().encodeToString(valueAsString.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * 
	 * @param userInfo
	 * @return
	 */
	public static Map<?, ?> extractApplicativeData(
			@SuppressWarnings("rawtypes") ResponseEntity<? extends Map> userInfo) {
		if (userInfo.getStatusCode().is2xxSuccessful()) {
			Map<?, ?> body = userInfo.getBody();

			// MiTrust provides an applicative_status next to the data.
			// For instance, a HTTP status of 2XX coupled with an application status 4XX means MiTrust application
			// received the call but the application client parameters are invalid
			Object status = body.get(IMiTrustWebConstants.KEY_STATUS);

			Map<?, ?> data = (Map<?, ?>) body.get(IMiTrustWebConstants.KEY_DATA);

			LOGGER.debug("Keys(data)={} (http_status={} applicative_status={})",
					computeKeys(data),
					userInfo.getStatusCode(),
					status);

			return data;
		} else {
			throw new IllegalStateException("HTTP status: " + userInfo.getStatusCode());
		}
	}

	/**
	 * 
	 * @param data
	 * @return a Set of keys, computed recursively
	 */
	public static Set<?> computeKeys(Map<?, ?> data) {
		Set<Object> keys = new LinkedHashSet<>();

		data.forEach((mainKey, value) -> {
			if (value instanceof Map<?, ?>) {
				Map<?, ?> subValueAsMap = (Map<?, ?>) value;
				computeKeys(subValueAsMap).forEach(subKey -> keys.add(mainKey + ":" + subKey));
			} else {
				keys.add(mainKey);
			}
		});

		return keys;
	}

	public static ResponseEntity<?> redirectTo(UriTemplateHandler uriTemplateHandler,
			String redirection,
			Object... params) {
		URI expandedUrl = uriTemplateHandler.expand(redirection, params);

		LOGGER.debug("Expanded {} and {} into {}", redirection, Arrays.toString(params), expandedUrl.toASCIIString());

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, expandedUrl.toASCIIString());

		return new ResponseEntity<>(headers, HttpStatus.FOUND);
	}
}
