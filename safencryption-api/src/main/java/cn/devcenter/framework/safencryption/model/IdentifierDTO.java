package cn.devcenter.framework.safencryption.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IdentifierDTO {

    @NotNull
    private String identifier;

}
