package com.gcdd.sample.form;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2019/1/4
 */
@Data
public class UserForm {

    @Null
    private String testNull;

    @NotNull
    private String testNotNull;

    @AssertTrue
    private Boolean testTrue;

    @AssertFalse
    private Boolean testFalse;

    @Min(100)
    private Integer testMin;

    @Max(100)
    private Integer testMax;

    @DecimalMin("100.00")
    private BigDecimal testDecimalMin;

    @DecimalMax("100.00")
    private BigDecimal testDecimalMax;

    @Size(min = 50, max = 100)
    private String testSize;

}
