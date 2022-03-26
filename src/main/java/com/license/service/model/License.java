package com.license.service.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class License extends RepresentationModel<License> {

    private long id;

    private String licenseId;

    private String description;

    private String organizationId;

    private String productName;

    private LicenseType licenseType;

    public static final long INCORRECT_ID = -1L;
}
