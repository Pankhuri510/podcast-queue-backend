package com.pankhuri.podcastqueue.controller;

import com.pankhuri.podcastqueue.model.QueueEntry;
import com.pankhuri.podcastqueue.model.User;
import com.pankhuri.podcastqueue.model.PodcastEpisode;
import com.pankhuri.podcastqueue.repository.QueueEntryRepository;
import com.pankhuri.podcastqueue.repository.UserRepository;
import com.pankhuri.podcastqueue.repository.PodcastEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    @Autowired
    private QueueEntryRepository queueEntryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PodcastEpisodeRepository episodeRepository;

    // ✅ Add episode to user's queue
    @PostMapping
    public QueueEntry addToQueue(@RequestParam Long userId, @RequestParam Long episodeId, @RequestParam(defaultValue = "false") boolean listened, @RequestParam(required = false) String notes) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        PodcastEpisode episode = episodeRepository.findById(episodeId).orElseThrow(() -> new RuntimeException("Episode not found"));

        QueueEntry entry = new QueueEntry();
        entry.setUser(user);
        entry.setEpisode(episode);
        entry.setListened(listened);
        entry.setNotes(notes);

        return queueEntryRepository.save(entry);
    }

    // ✅ Get a user's full queue
    @GetMapping("/{userId}")
    public List<QueueEntry> getUserQueue(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return queueEntryRepository.findByUser(user);
    }
    @PutMapping("/{queueId}")
    public QueueEntry updateQueueEntry(@PathVariable Long queueId,
                                    @RequestParam(required = false) Boolean listened,
                                    @RequestParam(required = false) String notes) {
        QueueEntry entry = queueEntryRepository.findById(queueId)
                .orElseThrow(() -> new RuntimeException("Queue entry not found"));

        if (listened != null) {
            entry.setListened(listened);
        }

        if (notes != null) {
            entry.setNotes(notes);
        }

        return queueEntryRepository.save(entry);
    }
    // 🗑️ Delete a queue entry
    @DeleteMapping("/{queueId}")
    public String deleteQueueEntry(@PathVariable Long queueId) {
        if (!queueEntryRepository.existsById(queueId)) {
            return "Queue entry with ID " + queueId + " not found.";
        }
        queueEntryRepository.deleteById(queueId);
        return "Queue entry with ID " + queueId + " has been deleted successfully.";
    }

}
