package com.pankhuri.podcastqueue.repository;

import com.pankhuri.podcastqueue.model.QueueEntry;
import com.pankhuri.podcastqueue.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueEntryRepository extends JpaRepository<QueueEntry, Long> {
    List<QueueEntry> findByUser(User user);
}
