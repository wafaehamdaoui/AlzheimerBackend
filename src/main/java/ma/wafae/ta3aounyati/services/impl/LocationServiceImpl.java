package ma.wafae.ta3aounyati.services.impl;

import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.dto.mappers.LocationMapper;
import ma.wafae.ta3aounyati.dto.requests.LocationRequest;
import ma.wafae.ta3aounyati.dto.responses.LocationResponse;
import ma.wafae.ta3aounyati.exceptions.ResourceNotFound;

import ma.wafae.ta3aounyati.models.Location;
import ma.wafae.ta3aounyati.repositories.LocationRepository;
import ma.wafae.ta3aounyati.services.LocationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    @Override
    public LocationResponse add(LocationRequest request) {
        Location location = LocationMapper.INSTANCE.requestToEntity(request);
        return LocationMapper.INSTANCE.entityToResponse(locationRepository.save(location));
    }

    @Override
    public List<LocationResponse> getAll() {
        return LocationMapper.INSTANCE.toDtos(locationRepository.findAll());
    }

    @Override
    public void delete(Integer id) {
        Location location = locationRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Location not found"));
        locationRepository.delete(location);
    }

    @Override
    public Page<LocationResponse> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public LocationResponse get(Integer integer) {
        return null;
    }

    @Override
    public LocationResponse update(LocationRequest request, Integer integer) {
        return null;
    }



    @Override
    public Long getCount() {
        return null;
    }
}
