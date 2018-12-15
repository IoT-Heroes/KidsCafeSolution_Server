package api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.heroes.dto.JSONResult;

public class ResponseHandler {

	public ResponseEntity<Object> sendResponse(Object obj, Status status) {

		if (status == Status.SUCCESS || status == Status.INSERT_SUCCESS || status == Status.UPDATE_SUCCESS
				|| status == Status.LOGIN_FAIL || status == Status.LOGIN_SUCCESS) {
			return success(obj, status);
		} else {
			return fail(obj, status);
		}
	}

	public ResponseEntity<Object> success(Object obj, Status status) {
		return ResponseEntity.ok(JSONResult.success(obj, status.getDetail(), status.getCode()));
	}

	public ResponseEntity<Object> fail(Object obj, Status status) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(JSONResult.fail(obj, status.getDetail(), status.getCode()));
	}

	public ResponseEntity<Object> fail(Exception exception, HttpStatus httpStatus, Status status) {
		return ResponseEntity.status(httpStatus).body(JSONResult.fail(exception.getMessage(), status.getCode()));
	}

}
