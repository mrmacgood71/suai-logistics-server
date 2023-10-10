package it.macgood.logisticsdevserver.company;

import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.company.model.RequestCompany;
import it.macgood.logisticsdevserver.user.DriverRepository;
import it.macgood.logisticsdevserver.user.ManagerRepository;
import it.macgood.logisticsdevserver.user.model.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ManagerRepository managerRepository;
    private final DriverRepository driverRepository;

    public Company getById(String id) {
        return companyRepository.findById(id).orElseThrow();
    }

    public String save(
            Long managerId,
            RequestCompany company
    ) {
        Company build = Company.builder()
                .name(company.getName())
                .build();
        Company savedCompany = companyRepository.save(build);
        managerRepository.updateCompany(savedCompany.getId(), managerId);
        return savedCompany.getId();
    }

    public List<Driver> getDriversByCompanyId(String companyId) {
        return driverRepository.findAll()
                .stream()
                .filter(driver -> driver.getCompany().getId().equals(companyId))
                .collect(Collectors.toList());
    }


}
