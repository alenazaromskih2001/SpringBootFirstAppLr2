package ru.zaromskih.SpringBootFirstAppLr2.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reguest {
    @NotBlank
    private String uid;
    private String operationUid;
    private String systemName;
    private String systemTime;
    private String source;
    private String communicationId;
    private String productCode;
    private String smsCode;
    private String templateId;


}
