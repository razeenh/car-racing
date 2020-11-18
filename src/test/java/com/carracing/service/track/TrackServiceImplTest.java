package com.carracing.service.track;

import com.carracing.dao.track.Track;
import com.carracing.dao.track.TrackRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TrackServiceImplTest {

    @Mock
    private TrackRepository repo;
    @InjectMocks
    private TrackServiceImpl trackService;

    private static final String TRACK = "1100110011";

    @Test
    public void canFindTracksSuccessfully() {
        when(repo.findAll()).thenReturn(getTracks());

        List<TrackDto> tracks = trackService.getTracks();

        verify(repo, times(1)).findAll();
        Assert.assertEquals(TRACK, tracks.get(0).getRoute());
    }

    private List<Track> getTracks() {
        List<Track> tracks = new ArrayList<>();
        Track track = new Track();
        track.setId(1);
        track.setRoute(TRACK);
        tracks.add(track);
        return tracks;
    }
}