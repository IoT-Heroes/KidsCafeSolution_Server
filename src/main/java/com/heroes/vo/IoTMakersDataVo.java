package com.heroes.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IoTMakersDataVo {

	private String responseCode;
	private List<DetailData> data;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<DetailData> getData() {
		return data;
	}

	public void setData(List<DetailData> data) {
		this.data = data;
	}

	public static class DetailData {
		private String svcCode;
		private String svcTgtSeq;
		private String groupTagCd;
		private String spotDevSeq;

		private String occDt; // 데이터 수집일시
		private SensorData attributes;

		public String getSvcCode() {
			return svcCode;
		}

		public void setSvcCode(String svcCode) {
			this.svcCode = svcCode;
		}

		public String getSvcTgtSeq() {
			return svcTgtSeq;
		}

		public void setSvcTgtSeq(String svcTgtSeq) {
			this.svcTgtSeq = svcTgtSeq;
		}

		public String getGroupTagCd() {
			return groupTagCd;
		}

		public void setGroupTagCd(String groupTagCd) {
			this.groupTagCd = groupTagCd;
		}

		public String getSpotDevSeq() {
			return spotDevSeq;
		}

		public void setSpotDevSeq(String spotDevSeq) {
			this.spotDevSeq = spotDevSeq;
		}

		public String getOccDt() {
			return occDt;
		}

		public void setOccDt(String occDt) {
			this.occDt = occDt;
		}

		public SensorData getAttributes() {
			return attributes;
		}

		public void setAttributes(SensorData attributes) {
			this.attributes = attributes;
		}

		public static class SensorData {
			@JsonProperty("Temp")
			private int temp;
			@JsonProperty("Touch")
			private int touch;

			public int getTemp() {
				return temp;
			}

			public void setTemp(int temp) {
				this.temp = temp;
			}

			public int getTouch() {
				return touch;
			}

			public void setTouch(int touch) {
				this.touch = touch;
			}

		}
	}

}
