package ma.wafae.ta3aounyati.services.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.mappers.PersonMapper;
import ma.wafae.ta3aounyati.dto.requests.PersonRequest;
import ma.wafae.ta3aounyati.dto.responses.PersonResponse;
import ma.wafae.ta3aounyati.exceptions.ResourceNotFound;
import ma.wafae.ta3aounyati.models.Person;
import ma.wafae.ta3aounyati.models.User;
import ma.wafae.ta3aounyati.repositories.PersonRepository;
import ma.wafae.ta3aounyati.services.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    @Override
    public PersonResponse add(@Valid PersonRequest request) {
        Person person = PersonMapper.INSTANCE.requestToEntity(request);
        return PersonMapper.INSTANCE.entityToResponse(personRepository.save(person));
    }

    @Override
    public List<PersonResponse> getAll() {
        return PersonMapper.INSTANCE.toDtos(personRepository.findAll());
    }

    @Override
    public Page<PersonResponse> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public PersonResponse get(Integer integer) {
        return null;
    }

    @Override
    public PersonResponse update(PersonRequest request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Person not found"));
        personRepository.delete(person);
    }

    @Override
    public Long getCount() {
        return null;
    }
}
