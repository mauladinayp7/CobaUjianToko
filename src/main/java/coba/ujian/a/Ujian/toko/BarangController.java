/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coba.ujian.a.Ujian.toko;

import coba.ujian.a.Ujian.toko.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
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
    
    @RequestMapping(value = "/getNama")
    public List<Barang> getAllBarang(){
        
        List<Barang> brg = new ArrayList<Barang>();
        return actrl.findBarangEntities();
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
