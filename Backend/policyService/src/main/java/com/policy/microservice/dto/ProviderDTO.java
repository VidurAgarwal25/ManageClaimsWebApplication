package com.policy.microservice.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.policy.microservice.model.Hospital;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ProviderDTO {
	
	@JsonProperty
	private @Getter @Setter Set<Hospital> providers;
		@JsonIgnore
		public ProviderDTO(Set<Hospital> providers) {
			this.providers=providers;
		}
		@JsonIgnore
		public Set<Hospital> getProviders() {
			return providers;
		}
		@JsonIgnore
		public void setProviders(Set<Hospital> providers) {
			this.providers = providers;
		}
		
		
		

}
