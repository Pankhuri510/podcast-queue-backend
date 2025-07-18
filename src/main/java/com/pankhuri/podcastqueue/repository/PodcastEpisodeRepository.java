package com.pankhuri.podcastqueue.repository;

import com.pankhuri.podcastqueue.model.PodcastEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodcastEpisodeRepository extends JpaRepository<PodcastEpisode, Long> {
    
}