package com.common.kafka;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class MessageUnit implements Serializable {
	private String name;
	private String version;
	private HashMap<String, Object> input;
}
