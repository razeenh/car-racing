package com.carracing.service.track;

import com.carracing.sdk.dto.DataTransferObject;
import lombok.Data;

@Data
public class TrackDto implements DataTransferObject {
    private String route;
}
