package ma.wafae.ta3aounyati.services.impl;

import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.mappers.JournalMapper;
import ma.wafae.ta3aounyati.dto.requests.JournalRequest;
import ma.wafae.ta3aounyati.dto.responses.JournalResponse;

import ma.wafae.ta3aounyati.exceptions.ResourceNotFound;
import ma.wafae.ta3aounyati.models.Journal;
import ma.wafae.ta3aounyati.repositories.JournalRepository;
import ma.wafae.ta3aounyati.services.JournalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class JournalServiceImpl implements JournalService {
    private final JournalRepository journalRepository;
    @Override
    public JournalResponse add(JournalRequest request) {
        Journal journal = JournalMapper.INSTANCE.requestToEntity(request);
        return JournalMapper.INSTANCE.entityToResponse(journalRepository.save(journal));
    }

    @Override
    public List<JournalResponse> getAll() {
        return JournalMapper.INSTANCE.toDtos(journalRepository.findAll());
    }

    @Override
    public void delete(Integer id) {
        Journal journal = journalRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Task not found"));
        journalRepository.delete(journal);
    }

    @Override
    public Page<JournalResponse> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public JournalResponse get(Integer integer) {
        return null;
    }

    @Override
    public JournalResponse update(JournalRequest request, Integer integer) {
        return null;
    }



    @Override
    public Long getCount() {
        return null;
    }
}
