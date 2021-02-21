package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OriginalAuthorizationResponse {
    @JsonProperty("accountCode")
    @NonNull
    private String accountCode;
    @JsonProperty("cardClientCode")
    @NonNull
    private String cardClientCode;
    @JsonProperty("amount")
    @NonNull
    private String amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("currencyCode")
    @NonNull
    private String currencyCode;
    @JsonProperty("transactionStatus")
    @NonNull
    private String transactionStatus;
    @JsonProperty("rejectDescription")
    private String rejectDescription;
    @JsonProperty("operationId")
    private String operationId;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("transactionRejectCode")
    private String transactionRejectCode;
}
