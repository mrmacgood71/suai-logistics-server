package it.macgood.logisticsdevserver.invite;

import it.macgood.logisticsdevserver.company.CompanyRepository;
import it.macgood.logisticsdevserver.user.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@AllArgsConstructor
public class InvitationService {

    private final ManagerRepository managerRepository;
    private final CompanyRepository companyRepository;

    public String getInvitationCode(Long managerId) {
        return managerRepository.findById(managerId).orElseThrow().getCompany().getId();
    }

}
