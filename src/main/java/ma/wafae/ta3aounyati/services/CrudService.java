package ma.wafae.ta3aounyati.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudService <RQ,RS,ID>{
    RS add(RQ request);
    List<RS> getAll();
    Page<RS> getAllPageable(Pageable pageable);
    RS get(ID id);
    RS update(RQ request, ID id);
    void delete(ID id);
    Long getCount();
}
