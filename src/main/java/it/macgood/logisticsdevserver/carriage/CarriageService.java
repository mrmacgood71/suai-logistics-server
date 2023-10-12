package it.macgood.logisticsdevserver.carriage;

import it.macgood.logisticsdevserver.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarriageService {

    private final CarriageRepository carriageRepository;
    private final VehicleRepository vehicleRepository;


    public List<Carriage> findAll() {
        return carriageRepository.findAll();
    }

    public Carriage findById(Long id) {
        return carriageRepository.findById(id).orElseThrow();
    }

}
