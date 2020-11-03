package com.thoughtworks.capacity.gtb.mvc.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBO {
    @NotNull
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    @Max(12)
    @Min(5)
    private String password;
    @Email
    private String email;
}
