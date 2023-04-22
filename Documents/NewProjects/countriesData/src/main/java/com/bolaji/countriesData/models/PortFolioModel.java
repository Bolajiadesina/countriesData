package com.bolaji.countriesData.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PortFolioModel {
    private String  name;
    private String fName;
    private String lName;
    private String role;
    private String executiveProfile;
   // <div class="bg-img" th:style="'background:url('+ @{/images/bkgd.jpg} +');'">
}
