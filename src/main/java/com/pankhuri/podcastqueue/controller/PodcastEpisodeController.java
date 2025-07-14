package com.pankhuri.podcastqueue.controller;
import com.pankhuri.podcastqueue.model.PodcastEpisode;
import com.pankhuri.podcastqueue.repository.PodcastEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
public class PodcastEpisodeController {
    @Autowired
    private PodcastEpisodeRepository episodeRepository;

    // GET all episodes
    @GetMapping
    public List<PodcastEpisode> getAllEpisodes() {
        return episodeRepository.findAll();
    }

    // POST new episode
    @PostMapping
    public PodcastEpisode createEpisode(@RequestBody PodcastEpisode episode) {
        return episodeRepository.save(episode);
    }
}
