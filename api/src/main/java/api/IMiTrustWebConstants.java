/*
 * Copyright © 2019 MiTrust (cto@m-itrust.com). Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */
package io.mitrust.oss.api;

/**
 * Some constants related to REST json
 * 
 * @author Benoit Lacelle
 *
 */
public interface IMiTrustWebConstants {
	// https://labs.omniti.com/labs/jsend/wiki
	String KEY_STATUS = "status";

	String KEY_MESSAGE = "message";
	// Equivalent HttpStatus
	String KEY_CODE = "http_status";

	String KEY_DATA = "data";

	String VALUE_STATUS_SUCCESS = "success";

	/**
	 * Call parameters led to issue
	 */
	String VALUE_STATUS_FAIL = "fail";

	/**
	 * Internal error
	 */
	String VALUE_STATUS_ERROR = "error";

	String KEY_ERROR = "error";
	String KEY_ERROR_DESCRIPTION = "error_description";
}
