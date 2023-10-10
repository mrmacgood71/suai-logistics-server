package it.macgood.logisticsdevserver.company;

import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.company.model.RequestCompany;
import it.macgood.logisticsdevserver.user.model.Driver;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company getByCompanyId(
            @PathVariable String id
    ) {
        return companyService.getById(id);
    }

    @GetMapping(value = "/{companyId}/getDrivers")
    public ResponseEntity<List<Driver>> getDriversByCompanyId(
            @PathVariable String companyId
    ) {
        try {
            List<Driver> drivers = companyService.getDriversByCompanyId(companyId);
            return ResponseEntity.ok(drivers);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/{managerId}/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCompany(
            @RequestBody RequestCompany company,
            @PathVariable String managerId
    ) {
        try {
            return ResponseEntity.ok(companyService.save(Long.parseLong(managerId), company));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
