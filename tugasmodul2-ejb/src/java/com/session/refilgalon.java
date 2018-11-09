/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Agung
 */
@Stateless
@LocalBean
public class refilgalon {
    
    DecimalFormat a = new DecimalFormat("0.0");
    String hasil;

    public String refil_aqua(double parameter) { /*19000*/
        hasil = a.format(parameter*19000);
        return hasil;
    }
    
    public String refil_vit(double parameter) { /*11500*/
        return (hasil = a.format(parameter*11500));
    }
    
    public String refil_cleo(double parameter) { /*13000*/
        return (hasil = a.format(parameter*13000));
    }
    
    public String refil_pelangi(double parameter) { /*15000*/
        return (hasil = a.format(parameter*15000));
    }
    
    public String refil_abal(double parameter) { /*4000*/
        return (hasil = a.format(parameter*4000));
    }
    
    public String refil_takbermerek(double parameter) { /*3500*/
        return (hasil = a.format(parameter*3500));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
