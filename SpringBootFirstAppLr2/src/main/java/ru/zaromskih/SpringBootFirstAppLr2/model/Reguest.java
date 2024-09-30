package ru.zaromskih.SpringBootFirstAppLr2.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(max = 32)
    private String uid;
    @NotBlank
    @Size(max = 32)
    private String operationUid;

    private String systemName;

    @NotBlank
    private String systemTime;

    private String source;

    @NotBlank
    @Max(100000)
    @Min(1)
    private String communicationId;


    private String productCode;

    private String smsCode;
    private String templateId;


}
