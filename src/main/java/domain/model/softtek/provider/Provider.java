/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.model.softtek.provider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author edwar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Provider {
    private int id;
    private String name;
    private String identification;
    private int numberOfVehicles;
}
