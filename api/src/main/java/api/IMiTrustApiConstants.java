/*
 * Copyright © 2019 MiTrust (cto@m-itrust.com). Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */
package io.mitrust.oss.api;

/**
 * The constants used by a SP to integrate with MiTrust
 * 
 * @author Benoit Lacelle
 *
 */
public interface IMiTrustApiConstants {
	// The root domain of MiTrust
	String DOMAIN = "m-itrust.com";

	// The sub-domain of Datasharing application
	String SUBDOMAIN = "app";

	// The path to generate oauth2 tokens. This is NOT prefixed with '/api'
	String API_OAUTH_TOKEN = "/oauth/token";

	// The root path, for most API
	String API_API = "/api";
}
