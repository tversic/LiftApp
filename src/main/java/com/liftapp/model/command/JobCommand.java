package com.liftapp.model.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobCommand {

    private String title;
    private String description;
    private String pickup_location;
    private String target_location;
    private Date issuedDate;
    private String dateNeeded;
    private String pickupHours;
    private String price;
    private String issuer_name;
    private String width;
    private String length;
    private String  weight;
}
