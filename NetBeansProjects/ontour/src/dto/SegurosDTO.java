/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisponce
 */
@XmlRootElement(name = "seguros")
@XmlAccessorType (XmlAccessType.FIELD)
public class SegurosDTO {
 
    @XmlElement(name = "seguro")
    private List<SeguroDTO> seguros;

    public List<SeguroDTO> getEmployees() {
        return seguros;
    }
 
    public void setEmployees(List<SeguroDTO> employees) {
        this.seguros = employees;
    }
    
}
