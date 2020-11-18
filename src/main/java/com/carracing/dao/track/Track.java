package com.carracing.dao.track;

import com.carracing.sdk.dao.Entity;
import lombok.Data;

@Data
public class Track implements Entity {
    private Integer id;
    private String route;
}
