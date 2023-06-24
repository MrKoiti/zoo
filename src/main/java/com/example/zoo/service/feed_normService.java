package com.example.zoo.service;

import com.example.zoo.repos.feed_normRep;
import com.example.zoo.models.feed_norm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class feed_normService {
    private final feed_normRep feed_normRep;

    @Autowired
    public feed_normService(feed_normRep feed_normRep) {
        this.feed_normRep = feed_normRep;
    }

    public List<feed_norm> getAllFeedNorm() {
        List<feed_norm> feed_norm = new ArrayList<>();
        feed_normRep.findAll().forEach(feed_norm::add);
        return feed_norm;
    }

    public feed_norm getFeedNorm(Integer id) {
        return feed_normRep.findById(id).orElse(null);
    }

    public void addFeedNorm(feed_norm feed_norm) {
        feed_normRep.save(feed_norm);
    }

    public void updateFeedNorm(feed_norm feed_norm) {
        feed_normRep.save(feed_norm);
    }

    public void deleteFeedNorm(Integer id) {
        feed_normRep.deleteById(id);
    }
}
