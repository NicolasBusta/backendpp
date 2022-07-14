package services.academicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import services.academicservice.converter.CareerConverter;
import services.academicservice.dto.CareerDTOGet;
import services.academicservice.dto.CareerDTOPost;
import services.academicservice.entity.Career;
import services.academicservice.exception.CareerNotFoundException;
import services.academicservice.repository.CareerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;
    private final CareerConverter careerConverter;

    @Autowired
    public CareerServiceImpl(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
        this.careerConverter = new CareerConverter();
    }


    public List<CareerDTOGet> fetchAllCareers(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Career> careers = careerRepository.findAll(paging);
        if (careers.isEmpty()) {
            throw new CareerNotFoundException("No careers found");
        }
        List<CareerDTOGet> listDTO = new ArrayList<>();
        for (Career career : careers) {
        	listDTO.add(careerConverter.entityToDTO(career));
		}
        return listDTO;
    }


    public List<CareerDTOGet> fetchAllCareer() {
        List<Career> careers = careerRepository.findAll();
        if (careers.isEmpty()) {
            throw new CareerNotFoundException("No careers found");
        }
        List<CareerDTOGet> listDTO = new ArrayList<>();
        for (Career career : careers) {
            listDTO.add(careerConverter.entityToDTO(career));
        }
        return listDTO;
    }

    /**
     *
     * @param id id of career to be searched
     * @return career object which id correlate with the request
     */
    public CareerDTOGet fetchCareerById(Long id) {
        Career career = careerRepository.findById(id)
                  .orElseThrow(() -> new CareerNotFoundException("Career id not found - " + id));

        return careerConverter.entityToDTO(career);
    }

    /**
     *
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and a HTTP status
     */
    public ResponseEntity<String> createCareer(CareerDTOPost dto) {
        String newDescription = dto.getDescription();
        String newLegalDescription = dto.getLegalDescription();
        String newCode = dto.getCode();
        if (careerRepository.findAllCareersBy(newDescription, newLegalDescription, newCode).isEmpty()) {
        	Career career = careerConverter.dtoToEntity(dto);
            careerRepository.save(career);
            return new ResponseEntity<>("Career created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Career already exists", HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param id id of career to be searched
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and a HTTP status
     */
    public ResponseEntity<String> updateCareer(Long id, CareerDTOPost dto) {
        Career career = careerRepository.findById(id)
                .orElseThrow(() -> new CareerNotFoundException("Career id not found - " + id));
        String newDescription = dto.getDescription();
        String newLegalDescription = dto.getLegalDescription();
        String newCode = dto.getCode();
        int careers = careerRepository.findAllCareersBy(id, newDescription, newLegalDescription, newCode).size();
        if (careers >= 1) {
            return new ResponseEntity<>("Career already exists", HttpStatus.CONFLICT);
        } else {

        	career.setDescription(dto.getDescription());
            career.setLegalDescription(dto.getLegalDescription());
            career.setStatus(dto.getStatus());
            career.setCode(dto.getCode());
            if (dto.getCareerType().equals("Profesional")) {
                career.setCareerType((short) 1);
            } else if (dto.getCareerType().equals("Técnico de Nivel Superior")) {
                career.setCareerType((short) 2);
            }
            career.setCareerCredits(dto.getCareerCredits());
            career.setCareerHours(dto.getCareerHours());
            career.getCareerBook().setBook(dto.getBook());
            career.getCareerBook().setInvoice(dto.getInvoice());
            
            careerRepository.save(career);
            return new ResponseEntity<>("Career updated successfully", HttpStatus.OK);
        }
    }

    /**
     *
     * @param id id of career to be searched
     * @return responseEntity object which contains a message and a HTTP status
     */
    public ResponseEntity<String> deleteCareerById(Long id) {
        Career career = careerRepository.findById(id)
                        .orElseThrow(() -> new CareerNotFoundException("Career id not found - " + id));
        careerRepository.delete(career);
        return new ResponseEntity<>("Career deleted successfully", HttpStatus.OK);
    }

}
