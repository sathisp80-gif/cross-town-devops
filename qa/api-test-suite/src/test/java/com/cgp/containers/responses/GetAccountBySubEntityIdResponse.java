package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountBySubEntityIdResponse {
//    @JsonProperty(value = "login_id")
//    @NonNull
//    private Integer loginId;
    @JsonProperty(value = "entity_code")
    @NonNull
    private String entityCode;
    @JsonProperty(value = "entity_name")
    @NonNull
    private String entityName;
    @JsonProperty(value = "sub_entity_name")
    @NonNull
    private String subEntityName;
    @JsonProperty(value = "sub_entity_code")
    @NonNull
    private String subEntityCode;
    @JsonProperty(value = "sub_entity_status")
    @NonNull
    private String subEntityStatus;
    @JsonProperty(value = "account_list")
    private List<AccountResponse> accountList;
}
