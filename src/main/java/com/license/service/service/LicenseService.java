package com.license.service.service;

import com.license.service.model.License;
import com.license.service.model.LicenseType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LicenseService {

    private final MessageSource messageSource;

    public License getLicense(String organizationId, String licenseId) {
        return License.builder()
                .id(Math.abs(new Random().nextLong()))
                .licenseId(licenseId)
                .organizationId(organizationId)
                .description("Software Product")
                .productName("Microsoft")
                .licenseType(LicenseType.FULL)
                .build();
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;

        if (Objects.nonNull(license)) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(
                    messageSource.getMessage("license.create.message", null, locale),
                    license);
        }

        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;

        if (Objects.nonNull(license)) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(
                    messageSource.getMessage("license.update.message", null, null),
                    license
            );
        }

        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String.format("Deleting license with Id: %s for the organization %s" , licenseId, organizationId);
    }

}
