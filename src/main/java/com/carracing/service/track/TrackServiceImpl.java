package com.carracing.service.track;

import com.carracing.dao.track.Track;
import com.carracing.dao.track.TrackRepository;
import com.carracing.sdk.mapper.DtoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TrackServiceImpl implements TrackService {

    private TrackRepository repo;
    private DtoMapper<Track, TrackDto> dtoMapper;

    public TrackServiceImpl(TrackRepository repo) {
        this.repo = repo;
        this.dtoMapper = new TrackDtoMapperImpl();
    }

    @Override
    public List<TrackDto> getTracks() {
        return repo.findAll().stream().map(dtoMapper::mapFrom).collect(Collectors.toList());
    }
}
