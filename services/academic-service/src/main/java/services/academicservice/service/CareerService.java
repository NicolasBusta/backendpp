package services.academicservice.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import services.academicservice.entity.Career;
import services.academicservice.repository.CareerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CareerService {

    private CareerRepository careerRepository;

    public CareerService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public List<Career> getAllCareers(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Career> pagedResult = careerRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Career>();
        }
    }

    public Career getCareerById(Long id) {
        return careerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
    }

    public Career createCareer(Career career) {
        return careerRepository.save(career);
    }

    public void deleteCareer(long id) {
        Career career = careerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
        careerRepository.delete(career);
    }

    public Career updateCareer(long id, Career careerRequest) {
        Career career = careerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
        career.setDescription(careerRequest.getDescription());
        return careerRepository.save(career);
    }
}
