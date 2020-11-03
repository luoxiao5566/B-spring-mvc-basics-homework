package com.thoughtworks.capacity.gtb.mvc.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBO {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
