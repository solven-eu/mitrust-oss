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
public interface IMiTrustOAuth2Constants {
	String API_OAUTH = "/oauth";

	// The path to generate oauth2 tokens. This is NOT prefixed with '/api'
	String API_OAUTH_TOKEN = API_OAUTH + "/token";

	// The standard OAuth2 state
	String STATE = "state";

	// If the state if a json, MiTrust will interpret the entry for keys starting with this prefix
	String PREFIX_STATE_GROUP = "mitrust_group_";
}
