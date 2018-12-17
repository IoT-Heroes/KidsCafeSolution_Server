package api;

import java.util.List;

import com.heroes.exception.ValidationException;
import com.heroes.vo.CafeVisitingRecordVo;
import com.heroes.vo.ChildVo;
import com.heroes.vo.StatisticsVo;
import com.heroes.vo.UserVo;

public class Validator {

	public void validate(Object obj, ValidationStatus type) {

		ValidationStatus status = ValidationStatus.SUCCESS;

		if (type == ValidationStatus.CHILD_INSERT_VALIDATION) {
			status = childInsertValidataion(obj);
		} else if (type == ValidationStatus.CHILD_SELECT_VALIDATION) {
			status = childSelectValidataion(obj);
		} else if (type == ValidationStatus.CAFE_VISITING_RECORD_INSERT_VALIDATION) {
			status = cafeVisitingRecordInsertValidation(obj);
		} else if (type == ValidationStatus.CAFE_VISITING_RECORD_SELECT_VALIDATION) {
			status = cafeVisitingRecordSelectValidation(obj);
		} else if (type == ValidationStatus.BATCH_HDTYPE_VALITATION) {
			status = batchHDTypeValidation(obj);
		} else if (type == ValidationStatus.BATCH_MHTYPE_VALITATION) {
			status = batchMHTypeValidation(obj);
		} else if (type == ValidationStatus.LOGIN_VALIDATION) {
			status = loginValidation(obj);
		} else if (type == ValidationStatus.JOIN_VALIDATION) {
			status = joinValidation(obj);
		}

		if (status != ValidationStatus.SUCCESS) {
			throw new ValidationException(status, obj);
		}

	}

	public ValidationStatus childInsertValidataion(Object obj) {
		List<ChildVo> childVoList = (List<ChildVo>) obj;

		if (childVoList.size() == 0) {
			return ValidationStatus.EMPTY_LIST;
		}
		for (ChildVo childVo : childVoList) {
			if (childVo.getBirth() == null || childVo.getUserId() == null || childVo.getSex() == null
					|| childVo.getName() == null) {
				return ValidationStatus.PARAM_ERROR;
			}
		}
		return ValidationStatus.SUCCESS;
	}

	public ValidationStatus childSelectValidataion(Object obj) {
		return ValidationStatus.SUCCESS;
	}

	public ValidationStatus cafeVisitingRecordInsertValidation(Object obj) {
		CafeVisitingRecordVo cafeVisitingRecordVo = (CafeVisitingRecordVo) obj;
		if (cafeVisitingRecordVo.getChildId() == null || cafeVisitingRecordVo.getBandDeviceId() == null) {
			return ValidationStatus.PARAM_ERROR;
		}
		return ValidationStatus.SUCCESS;
	}

	public ValidationStatus cafeVisitingRecordSelectValidation(Object obj) {
		CafeVisitingRecordVo cafeVisitingRecordVo = (CafeVisitingRecordVo) obj;
		return ValidationStatus.SUCCESS;
	}

	public ValidationStatus batchHDTypeValidation(Object obj) {
		StatisticsVo statisticsVo = (StatisticsVo) obj;
		if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_HOUR)
				|| statisticsVo.getBatchType().equals(Data.BATCH_TYPE_DAY)) {
			return ValidationStatus.SUCCESS;
		}
		return ValidationStatus.BATCH_TYPE_ERROR;
	}

	public ValidationStatus batchMHTypeValidation(Object obj) {
		StatisticsVo statisticsVo = (StatisticsVo) obj;
		if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_MINUTE)
				|| statisticsVo.getBatchType().equals(Data.BATCH_TYPE_HOUR)) {
			return ValidationStatus.SUCCESS;
		}

		return ValidationStatus.SUCCESS;
	}
	

	public ValidationStatus loginValidation(Object obj) {
		UserVo userVo = (UserVo)obj;
		
		if (userVo.getId() == null
				|| userVo.getPassword() == null) {
			return ValidationStatus.PARAM_ERROR;
		}
		return ValidationStatus.SUCCESS;
	}
	public ValidationStatus joinValidation(Object obj) {
		UserVo userVo = (UserVo)obj;
		
		if (userVo.getId() == null
				|| userVo.getPassword() == null
				|| userVo.getName() == null
				|| userVo.getPhoneNumber() == null) {
			return ValidationStatus.PARAM_ERROR;
		}
		return ValidationStatus.SUCCESS;
	}
}
