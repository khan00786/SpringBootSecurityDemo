package com.demo.candidate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateAPIController {

    private static final Logger log = LoggerFactory.getLogger(CandidateAPIController.class);

    @Autowired
    CandidateAPIService candidateAPIService;

    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates() {
        log.info("Hello World");
        return candidateAPIService.getAllCandidates();
    }

    @GetMapping("/test")
    public void test() {
        log.info("Hello World");
//        ObjectNode objectNode = new ObjectNode();



    }

    @PostMapping(value = "/candidates")
    public void addCandidate(@RequestBody Candidate candidate) {
        candidateAPIService.addCandidate(candidate);
    }

    @PutMapping(value = "/candidates/{id}")
    public void updateCandidate(@PathVariable String id, @RequestBody Candidate candidate) {
        candidate.setId(id);
        BufferedReader r;
        candidateAPIService.updateCandidate(candidate);
    }

    @DeleteMapping(value = "/candidates/{id}")
    public void deleteCandidate(@PathVariable String id) {
        candidateAPIService.deleteCandidate(id);
    }

    @GetMapping("/logging")
    public String testLogging() {
        return "CandidateAPIController Logs Invoked";
    }
}