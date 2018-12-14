package api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.heroes.dto.JSONResult;

public class ResponseHelper {

  public ResponseEntity<Object> sendResponse(Object obj, STATUS status) {

    if (status == STATUS.SUCCESS || status == STATUS.INSERT_SUCCESS || status == STATUS.UPDATE_SUCCESS) {
      return success(obj, status);
    } else {
      return fail(obj, status);
    }
  }

  public ResponseEntity<Object> success(Object obj, STATUS status) {
    return ResponseEntity.ok(JSONResult.success(obj, status.getDetail()));
  }

  public ResponseEntity<Object> fail(Object obj, STATUS status) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(obj, status.getDetail()));
  }

  public ResponseEntity<Object> fail(Exception exception,HttpStatus httpStatus,STATUS status) {
    
    
    return ResponseEntity.status(httpStatus).body(JSONResult.fail( exception.getMessage(),status.getCode()));
  }

}
