/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coba.ujian.a.Ujian.toko;

import coba.ujian.a.Ujian.toko.exceptions.NonexistentEntityException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mladi
 */
@Controller
@ResponseBody
public class BarangController {
    
    Barang data = new Barang ();
    BarangJpaController actrl = new BarangJpaController();
    
    @RequestMapping("/getNama/{id}")
    public String getNama (@PathVariable("id") int id)
    {
        try {
            data = actrl.findBarang(id);
            return data.getNama()+"<br>"+ data.getJumlah();
        }
        catch (Exception error) {return "Data tidak ada";}
    }
    
    @RequestMapping ("/delete/{id}")
    public String deleteData (@PathVariable("id") int id){
        try {
            actrl.destroy(id);
            return id + "DELETED";
        }
        catch (NonexistentEntityException error) {return id + "tidak ada";}
    }
}
