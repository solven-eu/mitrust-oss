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
public interface IMiTrustApiSpConstants extends IMiTrustApiConstants {
	String API_V1 = "/v1";

	// see io.mitrust.config.IMiTrustServiceProviderApiDefinition
	// TODO Prefix with '/api'
	String API_BACKEND_AUTOUPDATE = "/service_provider/v1/auto_update";

	// The path for all headless operations (AutoUpdate, KBis, ...)
	String API_HEADLESS = "/headless";

	String API_HEADLESS_KBIS = API_API + API_V1 + API_HEADLESS + "/company_data";

	String API_USERDATA = "/user_data";
	String MITRUST_DATA_RAW_PREFIX = API_USERDATA + API_V1;

	// https://openid.net/specs/openid-connect-core-1_0.html#UserInfo
	String API_USERINFO = "/userinfo";

	// TODO Prefix with '/api'
	@Deprecated
	String API_USERINFO_LEGACY = MITRUST_DATA_RAW_PREFIX + API_USERINFO;
	String API_USERDATA_USERINFO = API_API + API_V1 + API_USERDATA + API_USERINFO;
}
