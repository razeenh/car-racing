package com.carracing.dao.car;

import com.carracing.sdk.dao.Entity;
import lombok.Data;

@Data
public class Car implements Entity {
    private Integer id;
    private String name;
    private Integer acceleration;
    private Integer braking;
    private Integer corneringAbility;
    private Integer topSpeed;
}
