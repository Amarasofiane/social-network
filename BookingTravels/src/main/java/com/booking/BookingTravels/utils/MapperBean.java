package com.booking.BookingTravels.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class MapperBean<T, B> {

//	public List<T> entityToDto(ModelMapper modelmapper,List<B> entities,Class<T> targetClass){
//		return entities.stream().map(entity->modelmapper.map(entity, targetClass)).collect(Collectors.toList());
//	}

	public List<T> entitysToDtos(ModelMapper modelmapper, List<B> entities, Class<T> targetClass) {
		return entities.stream().map(entity -> modelmapper.map(entity, targetClass)).collect(Collectors.toList());
	}

	public T entityToDto(ModelMapper modelmapper, B entities, Class<T> targetClass) {
		return modelmapper.map(entities, targetClass);
	}
}
