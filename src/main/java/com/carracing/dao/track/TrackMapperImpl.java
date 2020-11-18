package com.carracing.dao.track;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackMapperImpl implements TrackMapper {

    @Override
    public List<Track> mapResult(ResultSet rs) throws SQLException {
        List<Track> tracks = new ArrayList<>();

        while (rs.next()) {
            Track track = new Track();
            track.setId(rs.getInt("id"));
            track.setRoute(rs.getString("route"));
            tracks.add(track);
        }

        return tracks;
    }
}
