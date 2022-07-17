package com.company.model;

import java.util.List;
import lombok.*;

@Builder
@Getter
@Setter
public class Response<T> {
	private Long count;
	private List<T> items;
	private List<String> errors;
}
