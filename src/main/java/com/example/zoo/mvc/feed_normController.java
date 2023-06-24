package com.example.zoo.mvc;


import com.example.zoo.repos.feed_normRep;
import com.example.zoo.service.feed_normService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.feed_norm;

import java.util.List;
@RestController
@RequestMapping("/feed_norm")
public class feed_normController {
    private final feed_normRep feed_normRep;
    private final feed_normService feed_normService;

    @Autowired
    public feed_normController(feed_normService feed_normService, feed_normRep feed_normRep) {
        this.feed_normService = feed_normService;
        this.feed_normRep = feed_normRep;
    }

    @GetMapping("/getall")
    public List<feed_norm> getAllFeedNorm() {
        return feed_normService.getAllFeedNorm();
    }

    @GetMapping("/{id}")
    public feed_norm getFeedNorm(@PathVariable Integer id) {
        return feed_normService.getFeedNorm(id);
    }

    @PostMapping("")
    public void createFeedNorm(@RequestBody feed_norm feed_norm) {
        feed_normService.updateFeedNorm(feed_norm);
    }

    @PutMapping("")
    public void updateFeedNorm(@RequestBody feed_norm feed_norm) {
        feed_normService.updateFeedNorm(feed_norm);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedNorm(@PathVariable Integer id) {
        feed_normService.deleteFeedNorm(id);
    }
}

