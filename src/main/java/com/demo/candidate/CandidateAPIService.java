package com.demo.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CandidateAPIService {

    @Autowired
    CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public boolean addCandidate(Candidate candidate) {
        candidateRepository.insert(candidate);
        return true;
    }

    public boolean deleteCandidate(String id) {
        candidateRepository.deleteById(id);
        return true;
    }

    public boolean updateCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
        return true;
    }
}
