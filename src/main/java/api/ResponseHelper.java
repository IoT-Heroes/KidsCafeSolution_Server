package api;

import java.sql.SQLException;
import java.text.ParseException;
import org.postgresql.util.PSQLException;
import org.quartz.SchedulerException;
import org.springframework.dao.DataIntegrityViolationException;
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

  public ResponseEntity<Object> fail(Object obj, Exception exception) {
    STATUS status;


    // SQLException


    if (exception instanceof DataIntegrityViolationException) {
      status = STATUS.DATA_INTEGRITY_VIOLATION_EXCEPTION;
    } else if (exception instanceof PSQLException) {
      status = STATUS.PSQL_EXCEPTION;
    } else if (exception instanceof ParseException) {
      status = STATUS.PARSE_EXCEPTION;
    } else if (exception instanceof ClassNotFoundException) {
      status = STATUS.CALSS_NOT_FOUND_EXCEPTION;
    } else if (exception instanceof NoSuchMethodException) {
      status = STATUS.NO_SUCH_METHOD_EXCEPTION;
    } else if (exception instanceof SchedulerException) {
      status = STATUS.SCHEDULER_EXCEPTION;
    } else if (exception instanceof SQLException) {
      status = STATUS.SQL_EXCEPTION;
    } else {
      status = STATUS.UNKNOWN_EXCEPTION;
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(obj, status.getDetail() + " : " + exception.getMessage()));
  }

}
