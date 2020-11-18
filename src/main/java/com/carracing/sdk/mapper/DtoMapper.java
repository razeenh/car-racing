package com.carracing.sdk.mapper;

import com.carracing.sdk.dao.Entity;
import com.carracing.sdk.dto.DataTransferObject;

public interface DtoMapper<E extends Entity, D extends DataTransferObject> {
    D mapFrom(E entity);
}
