package com.common.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MessageUnitSerializer implements Serializer<MessageUnit> {
	protected ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map configs, boolean isKey) {
		// nothing to do
	}

	@Override
	public byte[] serialize(String topic, MessageUnit data) {
		try {
			return objectMapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			//throw new VendorInventoryException(e.getMessage());
//			log.error("JsonProcessingException occurs", e);
			return null;
		}
	}

	@Override
	public void close() {

	}
}
