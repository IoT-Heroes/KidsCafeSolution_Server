package api;

public enum ValidationStatus {

	   SUCCESS(200,"SUCCESS")   
	  ,INSERT_SUCCESS(2001,"INSERT_SUCCESS")
	  
	  
	  ,CHILD_INSERT_VALIDATION(3001,"CHILD_INSERT_ERROR")
	  ,CHILD_SELECT_VALIDATION(3002,"CHILD_SELECT_VALIDATION")
	  ,CAFE_VISITING_RECORD_INSERT_VALIDATION(3003,"CAFE_VISITING_RECORD_INSERT_VALIDATION")
	  ,CAFE_VISITING_RECORD_SELECT_VALIDATION(3004,"CAFE_VISITING_RECORD_SELECT_VALIDATION")
	  
	  
	  ,EMPTY_LIST(4001,"EMPTY_LIST")
	  ,PARAM_ERROR(4002,"PARAM_ERROR")
	  
	  
	  
	  ,BATCH_TYPE_EXCEPTION(5001,"BATCH_TYPE_EXCEPTION")
	  ;
	  
	  
	  
	  private final int codeName;
	  private final String detail;

	  private ValidationStatus(int code, String detailStr) {
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