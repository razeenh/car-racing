package com.carracing.dao.track;

import com.carracing.sdk.dao.JdbcWrapper;

import java.util.List;

public class TrackRepositoryImpl extends JdbcWrapper implements TrackRepository {

    @Override
    public List<Track> findAll() {
        return super.executeQuery("select * from track", new TrackMapperImpl());
    }
}
