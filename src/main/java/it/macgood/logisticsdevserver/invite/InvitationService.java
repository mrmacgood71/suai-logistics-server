package it.macgood.logisticsdevserver.invite;

import it.macgood.logisticsdevserver.company.CompanyRepository;
import it.macgood.logisticsdevserver.user.DriverRepository;
import it.macgood.logisticsdevserver.user.ManagerRepository;
import it.macgood.logisticsdevserver.user.model.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@AllArgsConstructor
public class InvitationService {

    private final ManagerRepository managerRepository;
    private final CompanyRepository companyRepository;
    private final DriverRepository driverRepository;

    public String getInvitationCode(Long managerId) {
        return managerRepository.findById(managerId).orElseThrow().getCompany().getId();
    }

    public void accept(Long userId, String companyId) {
        Driver driver = driverRepository.findById(userId).get();
        driver.setCompany(companyRepository.findById(companyId).get());
        Driver save = driverRepository.save(driver);
    }
}
