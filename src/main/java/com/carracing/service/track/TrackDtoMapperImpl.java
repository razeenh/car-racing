package com.carracing.service.track;

import com.carracing.dao.track.Track;
import com.carracing.sdk.mapper.DtoMapper;

public class TrackDtoMapperImpl implements DtoMapper<Track, TrackDto> {

    @Override
    public TrackDto mapFrom(Track entity) {
        TrackDto trackDto = new TrackDto();
        trackDto.setRoute(entity.getRoute());
        return trackDto;
    }
}
