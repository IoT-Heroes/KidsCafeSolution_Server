package api;

public enum STATUS {

   SUCCESS(200,"SUCCESS")   
  ,INSERT_SUCCESS(2001,"INSERT_SUCCESS")
  ,SELECT_SUCCESS(2002,"SELECT_SUCCESS")
  ,UPDATE_SUCCESS(1003,"UPDATE_SUCCESS")
  
  
  
  ,FAIL(400,"FAIL")
  ,INSERT_FAIL(401,"INSERT_FAILE")
  ,SELECT_FAIL(401,"SELECT_FAILE")
  ,UPDATE_FAIL(401,"UPDATE_FAILE")
  
  
  
  
  ,DATA_INTEGRITY_VIOLATION_EXCEPTION(3001,"DATA_INTEGRITY_VIOLATION_EXCEPTION") 
  ,PSQL_EXCEPTION(3002,"PSQL_EXCEPTION")
  ,PARSE_EXCEPTION(3003,"PARSE_EXCEPTION")
  ,CALSS_NOT_FOUND_EXCEPTION(3004,"CLASS_NOT_FOUND_EXCEPTION")
  ,NO_SUCH_METHOD_EXCEPTION(3005,"NO_SUCH_METHOD_EXCEPTION")
  ,SCHEDULER_EXCEPTION(3006,"SCHEDULER_EXCEPTION")
  ,SQL_EXCEPTION(3007,"SQL_EXCEPTION")
  
  ,UNKNOWN_EXCEPTION(3999,"EXCEPTION")
  
  
  ;
  
  
  
  private final int codeName;
  private final String detail;

  private STATUS(int code, String detailStr) {
    this.codeName = code;
    this.detail = detailStr;
  }

  public int getCode() {
    return codeName;
  }
  
  public String getDetail() {
    return detail;    
  }
}
