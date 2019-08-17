package com.common.kafka;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class MessageUnitDeserializer implements Deserializer<MessageUnit> {
	protected ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// nothing to do
	}

	@Override
	public MessageUnit deserialize(String topic, byte[] data) {
		Type type = getUnderlyingType(this.getClass());
		Class<?> genericClass = getGenericClass((ParameterizedType) type);
		JavaType javaType = objectMapper.getTypeFactory().constructType(genericClass);
		try {
			return objectMapper.readValue(data, javaType);
		} catch (IOException e) {
			//throw new VendorInventoryException(e.getMessage());
//			log.error("IOException occurs", e);
			return null;
		}
	}

	@Override
	public void close() {
		// nothing to do
	}

	protected Type getUnderlyingType(Class<?> clazz) {
		Type[] genericInterfaces = clazz.getGenericInterfaces();
		if (genericInterfaces.length == 0) {
			return clazz.getAnnotatedSuperclass().getType();
		}

		return genericInterfaces[0];
	}

	protected Class<?> getGenericClass(ParameterizedType type) {
		return (Class<?>) type.getActualTypeArguments()[0];
	}
}
