package com.policy.microservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ValidatingDTO {
	
		@JsonProperty
	    private @Getter @Setter boolean validStatus;

		public boolean isValidStatus() {
			return validStatus;
		}

		public void setValidStatus(boolean validStatus) {
			this.validStatus = validStatus;
		}

}


