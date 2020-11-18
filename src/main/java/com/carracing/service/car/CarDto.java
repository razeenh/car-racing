package com.carracing.service.car;

import com.carracing.sdk.dto.DataTransferObject;
import lombok.Data;

@Data
public class CarDto implements DataTransferObject {
    private String name;
    private int acceleration;
    private int braking;
    private int corneringAbility;
    private int topSpeed;
}
