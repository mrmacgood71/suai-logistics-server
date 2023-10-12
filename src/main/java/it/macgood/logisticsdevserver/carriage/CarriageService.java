package it.macgood.logisticsdevserver.carriage;

import it.macgood.logisticsdevserver.carriage.model.Carriage;
import it.macgood.logisticsdevserver.carriage.model.CarriageMapper;
import it.macgood.logisticsdevserver.carriage.model.RequestCarriage;
import it.macgood.logisticsdevserver.carriage.model.ResponseCarriage;
import it.macgood.logisticsdevserver.company.CompanyRepository;
import it.macgood.logisticsdevserver.geolocation.TownRepository;
import it.macgood.logisticsdevserver.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarriageService {

    private final CarriageRepository carriageRepository;
    private final VehicleRepository vehicleRepository;
    private final TownRepository townRepository;
    private final CompanyRepository companyRepository;


    public List<Carriage> findAll() {
        return carriageRepository.findAll();
    }
    public List<ResponseCarriage> findAllByCompanyId(String id) {
        var response = new ArrayList<ResponseCarriage>();

        carriageRepository.findAll()
                .stream()
                .filter(carriage -> carriage.getCompany().getId().equals(id))
                .toList()
                .forEach(carriage -> response.add(CarriageMapper.CarriageToResponseCarriage(carriage)));

        return response;
    }

    public Carriage findById(Long id) {
        return carriageRepository.findById(id).orElseThrow();
    }

    public Boolean changeStatus(Long id) {
        Carriage carriage = carriageRepository.findById(id).get();
        carriage.setStatus("Отменена");
        carriageRepository.save(carriage);
        return true;
    }

    public List<ResponseCarriage> findAllByStatus(String type) {
        List<ResponseCarriage> response = new ArrayList<>();
        List<Carriage> carriages = carriageRepository.findAll();
        if (type.equals("Отменена") || type.equals("Завершена")) {


            carriages.stream()
                    .filter(carriage -> carriage
                            .getStatus().equals("Завершена") || carriage.getStatus().equals("Отменена"))
                    .toList()
                    .forEach(carriage -> response.add(CarriageMapper.CarriageToResponseCarriage(carriage)));

            return response;
        } else {
            carriages.stream()
                    .filter(carriage -> carriage.getStatus().equals("В пути"))
                    .toList()
                    .forEach(carriage -> response.add(CarriageMapper.CarriageToResponseCarriage(carriage)));
            return response;
        }
    }

    public ResponseCarriage saveCarriage(RequestCarriage request) {

        Carriage carriage = CarriageMapper.RequestCarriageToCarriage(
                request,
                townRepository.findById(request.getDestinationTownId()).get(),
                townRepository.findById(request.getDepartureTownId()).get(),
                companyRepository.findById(request.getCompanyId()).get(),
                vehicleRepository.findByTransportNumber(request.getVehicleId())
        );

        Carriage saved = carriageRepository.save(carriage);

        ResponseCarriage response = CarriageMapper.CarriageToResponseCarriage(saved);


        return response;
    }


    public ResponseCarriage findByDriver(Long id) {
        Optional<Carriage> first = carriageRepository.findAll()
                .stream()
                .filter(carriage -> carriage.getStatus().equals("В пути"))
                .filter(carriage -> carriage.getVehicle().getDriver().getId().equals(id))
                .findFirst();


        return CarriageMapper.CarriageToResponseCarriage(first.get());
    }
}
